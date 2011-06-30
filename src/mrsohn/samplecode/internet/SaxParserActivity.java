package mrsohn.samplecode.internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

public class SaxParserActivity {
	Context context;
	public SaxParserActivity(Context context) {
		this.context = context;
		APIData();
	}
	
	private void APIData() {
		// XML을 가져온다.
	    URL url;
	    try {
//	        String quakeFeed = getString(R.string.quake_feed);
//	    	String quakeFeed = "http://openapi.naver.com/search?key=6352c6e92f9a5981ffc32f5d8c27dd21" +
//	    						"&query=android&display=10&start=1&target=book";
	    	String requestURL = "http://openapi.naver.com/search?" +
				    			"key=6352c6e92f9a5981ffc32f5d8c27dd21" +
				    			"&query=nhn&target=recmd";

	        url = new URL(requestURL);

	        URLConnection connection;
	        connection = url.openConnection();

	        HttpURLConnection httpConnection = (HttpURLConnection)connection;
	        int responseCode = httpConnection.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            InputStream in = httpConnection.getInputStream(); 
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();

	            // 지진 정보 피드를 파싱한다.
	            Document dom = db.parse(in);
	            Element docEle = dom.getDocumentElement();

	            // 이전에 있던 지진 정보들을 모두 삭제한다.
//	            earthquakes.clear();

	            // 지진 정보로 구성된 리스트를 얻어온다.
	            NodeList nl = docEle.getElementsByTagName("item");
	            if (nl != null && nl.getLength() > 0) {
	                for (int i = 0 ; i < nl.getLength(); i++) {
	                    Element entry = (Element)nl.item(i);
	                    
	                    Log.e(String.valueOf(i), "title :" +entry.getFirstChild().getNodeValue());
	                    
//	                    Element title = (Element)entry.getElementsByTagName("title").item(0);
	                    Element link = (Element)entry.getElementsByTagName("link").item(0);
//	                    Element description = (Element)entry.getElementsByTagName("description").item(0);
//	                    Element lastBuildDate = (Element)entry.getElementsByTagName("lastBuildDate").item(0);

	                    Element K = (Element)entry.getElementsByTagName("item").item(0);
	                    
	                    Toast.makeText(context, String.valueOf(K), 200).show();
//	                    Log.e(String.valueOf(i), "title :" +title.getFirstChild().getNodeValue());
//	                    Log.e(String.valueOf(i), "link :" +link.getFirstChild().getNodeValue());
//	                    Log.e(String.valueOf(i), "description :" +description.getFirstChild().getNodeValue());
//	                    Log.e(String.valueOf(i), "lastBuildDate :" +lastBuildDate.getFirstChild().getNodeValue());

//	                    Log.e(String.valueOf(i), "title :" +K.getLastChild());

	                    
//	                    String linkString = link.getAttribute("href");
	                    
//	                    Log.e("lingString", linkString);
//	                    String point = g.getFirstChild().getNodeValue();
//	                    String dt = when.getFirstChild().getNodeValue();
//	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
//	                    Date qdate = new GregorianCalendar(0,0,0).getTime();
//	                    try {
//	                        qdate = sdf.parse(dt);
//	                    } catch (ParseException e) {
//	                        e.printStackTrace();
//	                    }
//
//	                    String[] location = point.split(" ");
//	                    Location l = new Location("dummyGPS");
//	                    l.setLatitude(Double.parseDouble(location[0]));
//	                    l.setLongitude(Double.parseDouble(location[1]));

//	                    String magnitudeString = details.split(" ")[1];
//	                    int end = magnitudeString.length()-1;
//	                    double magnitude = Double.parseDouble(magnitudeString.substring(0, end));
//
//	                    details = details.split(",")[1].trim();

//	                    Quake quake = new Quake(qdate, details, l, magnitude, linkString);

	                    // 새로운 지진 정보를 처리한다.
//	                    addNewQuake(quake);
	                }
	            }
	        }
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e) {
	        e.printStackTrace();
	    } finally {
	    }

	}
}
