package mrsohn.samplecode.sensor;

import java.util.List;
import java.util.Locale;

import mrsohn.samplecode.R;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class GeoLocation extends Activity{
	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.sensor);
	    
	    LocationManager locationManager;
	    String context = Context.LOCATION_SERVICE;
	    locationManager = (LocationManager)getSystemService(context);
	      
	    Criteria criteria = new Criteria();
	    criteria.setAccuracy(Criteria.ACCURACY_COARSE);// 정확도
	    criteria.setPowerRequirement(Criteria.POWER_LOW); // 전원 소비량
	    criteria.setAltitudeRequired(false); // 고도 사용여부
	    criteria.setBearingRequired(false); //
	    criteria.setSpeedRequired(false); // 속도
	    criteria.setCostAllowed(true); // 금전적비용

	    String provider = locationManager.getBestProvider(criteria, true);
	    Location location = locationManager.getLastKnownLocation(provider);

	    double latitude = location.getLatitude(); // 위도
	    double longitude = location.getLongitude(); // 경도

	    Geocoder gcK = new Geocoder(getApplicationContext(),Locale.KOREA);
	                try {
	                    List<Address>  addresses = gcK.getFromLocation(latitude, longitude, 1);
	                    StringBuilder sb = new StringBuilder();
	                    
	                    String tStr = null, tStrLocal = null, addressString;
	                    if (addresses.size() > 0) {
	                        for (Address addr : addresses) {
	                            sb.append(addr.getMaxAddressLineIndex()).append("********\n");
	                            for (int i=0;i < addr.getMaxAddressLineIndex();i++) 
	                                sb.append(addr.getAddressLine(i)).append("<< \n\n");
	                        }
	                        sb.append("===========\n");
	                        
	                        Address address = addresses.get(0);
	                        sb.append(address.getCountryName()).append("\n");
	                        sb.append(address.getPostalCode()).append("\n");
	                        sb.append(address.getLocality()).append("\n");
	                        sb.append(address.getThoroughfare()).append("\n");
	                        sb.append(address.getFeatureName()).append("\n\n");
	                        
	                        sb.append(tStr).append("\n");
	                        sb.append(tStrLocal).append("\n");
	                        
	                        addressString = sb.toString();
	                        
	                        Log.e("GeoLocation", addressString);
	                    }

	                } catch (Exception e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	    
	    
//	    LocationManager locationManager;
//	    String context = Context.LOCATION_SERVICE;
//	    locationManager = (LocationManager)getSystemService(context);

//	    Criteria criteria = new Criteria();
//	    criteria.setAccuracy(Criteria.ACCURACY_FINE);
//	    criteria.setAltitudeRequired(false);
//	    criteria.setBearingRequired(false);
//	    criteria.setCostAllowed(true);
//	    criteria.setPowerRequirement(Criteria.POWER_LOW);
//	    String provider = locationManager.getBestProvider(criteria, true);

//	    Criteria criteria = new Criteria();
//	    criteria.setAccuracy(Criteria.ACCURACY_COARSE);// 정확도
//	    criteria.setPowerRequirement(Criteria.POWER_LOW); // 전원 소비량
//	    criteria.setAltitudeRequired(false); // 고도 사용여부
//	    criteria.setBearingRequired(false); //
//	    criteria.setSpeedRequired(false); // 속도
//	    criteria.setCostAllowed(true); // 금전적비용
	    
//	    String provider = locationManager.getBestProvider(criteria, true);
//	    
//		Location location = locationManager.getLastKnownLocation(provider);
//	    updateWithNewLocation(location);
//
//	    locationManager.requestLocationUpdates(provider, 2000, 10,
//	                                           locationListener);
	  }
	  
//	  private final LocationListener locationListener = new LocationListener() {
//	    public void onLocationChanged(Location location) {
//	      updateWithNewLocation(location);
//	    }
//		 
//	    public void onProviderDisabled(String provider){
//	      updateWithNewLocation(null);
//	    }
//
//	    public void onProviderEnabled(String provider){ }
//	    public void onStatusChanged(String provider, int status, 
//	                                Bundle extras){ }
//	  };
//
//	  private void updateWithNewLocation(Location location) {
//	    String latLongString;
////	    TextView myLocationText; 
////	    myLocationText = (TextView)findViewById(R.id.myLocationText);
//	    if (location != null) {
//	      double lat = location.getLatitude();
//	      double lng = location.getLongitude();
//	      latLongString = "Lat:" + lat + "\nLong:" + lng;
//	    } else {
//	      latLongString = "No location found"; 
//	    }
////	    myLocationText.setText("Your Current Position is:\n" +  latLongString);
//	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static final String TAG = "GeoLocation";
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.sensor);
//		
//		String context = Context.LOCATION_SERVICE;
//		LocationManager locationManager = (LocationManager)getSystemService(context);	
//		
//		Criteria criteria = new Criteria();
//	    criteria.setAccuracy(Criteria.ACCURACY_FINE);
//	    criteria.setAltitudeRequired(false);
//	    criteria.setBearingRequired(false);
//	    criteria.setCostAllowed(true);
//	    criteria.setPowerRequirement(Criteria.POWER_LOW);
//	    String provider = locationManager.getBestProvider(criteria, true);
//		
//		Location location = locationManager.getLastKnownLocation(provider);
//		Log.e("GeoLocation" , String.valueOf(location));
//		
//		/**
//		 * 2초마다 위치 변화 감지 
//		 * 1미터 이상 움직임 감지된 경우 호출
//		 */
//		locationManager.requestLocationUpdates(provider, 2000, 1, locationListener);
//		
//		
//	}
//	
//	public String updateWithNewLocation(Location location){
//		String addressString;
//		double latitude = 0, longitude = 0;
//		if (location != null) {
//			latitude = location.getLatitude(); 	//위도
//			longitude = location.getLongitude();	//경도
//			addressString = latitude+","+longitude;			//위도,경도 
//			
//			Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//			try {
//				List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
//				StringBuilder sb = new StringBuilder();
//				if (addresses.size() > 0) {
//					Address address = addresses.get(0);
//					for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
//						sb.append(address.getAddressLine(i)).append("\n");
//						
//						sb.append(address.getLocality()).append("\n");
//						sb.append(address.getPostalCode()).append("\n");
//						sb.append(address.getCountryName());
//					}
//					addressString = sb.toString();
//					Log.e(TAG, "위도 : "+String.valueOf(latitude));
//					Log.e(TAG, "경도  : "+String.valueOf(longitude));
//					Log.e(TAG, "주소  : "+addressString);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else {
//			addressString = "위치를 찾을수 없음";
//		}
//		String result = String.valueOf(latitude) + String.valueOf(longitude) +addressString;
//		return result;
//	}
//	
//	private final LocationListener locationListener = new LocationListener() {
//		String provider = LocationManager.GPS_PROVIDER;
////		String provider = LocationManager.NETWORK_PROVIDER;
//		
//		int t = 5000; 		//밀리초
//		int distance = 5; 	//5미터
//		
//		@Override
//		public void onLocationChanged(Location location) {
//			// 새로운 위치를 기반으로 애플리케이션을 업데이트 한다
//			updateWithNewLocation(location);
//		}
//		@Override
//		public void onProviderDisabled(String provider) {
//			// 위치프로바디어가 활성화 된 경우 애플리케이션을 업데이트 한다
//			updateWithNewLocation(null);
//		}
//		@Override
//		public void onStatusChanged(String provider, int status, Bundle extras) {
//			// 위치 프로바이더의 하드웨어 상태가 변경된 경우 애플리케이션을 업데이트 한다.
//		}
//		@Override
//		public void onProviderEnabled(String provider) {
//			// 위치 프로바이더가 비 활성화 된 경우 애플리케이션을 업데이트 한다
//		}
//		
//	};
}
