
// TemperatureServerImpl Class

import java.rmi.*;
        import java.rmi.server.*;
        import java.util.*;
        import java.io.*;
        import java.net.*;

public class TemperatureServerImpl extends UnicastRemoteObject implements TemperatureServer {
    private WeatherInfo weatherInformation[];

    public TemperatureServerImpl() throws RemoteException
    {
        super();
        updateWeatherConditions();
    }

    // get weather information from NWS
    private void updateWeatherConditions() throws RemoteException {
        try {
            System.err.println(
                    "Updating weather information..." );

            // Traveler's Forecast Web Page
            URL url = new URL( "http://iwin.nws.noaa.gov/iwin/us/traveler.html" );

            BufferedReader in = new BufferedReader( new InputStreamReader( url.openStream() ) );

            String separator = "TAV12";

            // locate first horizontal line on Web page
            while ( !in.readLine().startsWith( separator ) );    // do nothing

            // s1 is the day format and s2 is the night format
            String s1 ="CITY            WEA     HI/LO   WEA     HI/LO";
            String s2 ="CITY            WEA     LO/HI   WEA     LO/HI";
            String inputLine = "";

            // locate header that begins weather information
            do {
                inputLine = in.readLine();
            } while ( !inputLine.equals( s1 ) && !inputLine.equals( s2 ) );

            Vector cityVector = new Vector();

            inputLine = in.readLine();  // get first city's info

            while ( inputLine.length() > 28 ) {
                // create WeatherInfo object for city
                WeatherInfo w = new WeatherInfo(
                        inputLine.substring( 0, 16 ),
                        inputLine.substring( 16, 22 ),
                        inputLine.substring( 23, 29 ) );

                cityVector.addElement( w ); // add to Vector
                inputLine = in.readLine();  // get next city's info
            }

            // create array to return to client
            weatherInformation = new WeatherInfo[ cityVector.size() ];

            for ( int i = 0; i < weatherInformation.length; i++ )
                weatherInformation[ i ] = ( WeatherInfo ) cityVector.elementAt( i );

            System.err.println( "Finished Processing Data." );
            in.close();  // close connection to NWS server
        }
        catch( java.net.ConnectException ce ) {
            System.err.println( "Connection failed." );
            System.exit( 1 );
        }
        catch( Exception e ) {
            e.printStackTrace();
            System.exit( 1 );
        }
    }

    // implementation for TemperatureServer interface method
    public WeatherInfo[] getWeatherInfo()
    {
        return weatherInformation;
    }

    public static void main( String args[] ) throws Exception
    {
        System.err.println(
                "Initializing server: please wait." );

        // create server object
        TemperatureServerImpl temp = new TemperatureServerImpl();

        // bind TemperatureServerImpl object to the rmiregistry default port 1099
        String serverObjectName = "//localhost/TempServer";
        Naming.rebind( serverObjectName, temp );
        System.err.println( "The Temperature Server is up and running." );
    }
}