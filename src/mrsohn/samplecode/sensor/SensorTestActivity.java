package mrsohn.samplecode.sensor;

import mrsohn.samplecode.R;
import android.R.integer;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorTestActivity extends Activity implements SensorEventListener {
	private static final String TAG = "Sensor";

	SensorManager sensorManager;
	SensorEventListener accL;
	SensorEventListener oriL;
	SensorEventListener ligL;
	SensorEventListener magL;
	SensorEventListener preL;
	SensorEventListener proxL;
	SensorEventListener tempL;
	
	/** 안드로이드 센서 */
	Sensor oriSensor; // 방향 센서
	Sensor accSensor; // 가속도 센서
	Sensor rotSensor; // 회전 센서
	Sensor ligSensor; // 밝기 센서
	Sensor magSensor; // 자기 센서
	Sensor preSensor; // 압력 센서
	Sensor proxSensor; // 근접 센서
	Sensor tempSensor; // 온도 센서

	float maxAccX;
	float maxAccY;
	float maxAccZ;

	TextView ori, acc, lig, mag, pre, prox, temp;
	TextView maxAcc;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE); // SensorManager
																// 인스턴스를 가져옴

		oriSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION); // 방향 센서
		accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); // 가속도 센서
		// rotSensor = sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR); // 회전 센서
		ligSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); // 밝기 센서
		magSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); // 자력 센서
		preSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE); // 압력 센서
		proxSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY); // 근접 센서
		tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE); // 온도 센서

		/*
		 * oriL = new oriListener(); // 방향 센서 리스너 인스턴스 accL = new accListener();
		 * // 가속도 센서 리스너 인스턴스 ligL = new ligListener(); magL = new
		 * magListener(); preL = new preListener(); proxL = new proxListener();
		 * tempL = new tempListener();
		 */

		ori = (TextView) findViewById(R.id.ori);
		acc = (TextView) findViewById(R.id.acc);
		lig = (TextView) findViewById(R.id.lig);
		mag = (TextView) findViewById(R.id.mag);
		pre = (TextView) findViewById(R.id.pre);
		prox = (TextView) findViewById(R.id.prox);
		temp = (TextView) findViewById(R.id.temp);
		maxAcc = (TextView) findViewById(R.id.maxAcc);

		maxAccX = -10;
		maxAccY = -10;
		maxAccZ = -10;
	}

	@Override
	public void onResume() {
		super.onResume();
		/**센서를 민감하게 설정하려면 SENSOR_DELAY_FASTEST) */
		
		// 가속도 센서  리스너  오브젝트를  등록
		sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
		 // 방향 센서  리스너  오브젝트를  등록
		sensorManager.registerListener(this, oriSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, ligSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, magSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, preSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	@Override
	public void onPause() {
		super.onPause();
		//액티비티 종료시 등록되었던 Listener 해제  
		sensorManager.unregisterListener(this); // unregister acceleration listener
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized (this) {
			float var0 = event.values[0];
			float var1 = event.values[1];
			float var2 = event.values[2];

			switch (event.sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:	//가속 
				acc.setText("x = " + var0 + " , y = " + var1 + " , z = " + var2);

				if (maxAccX < var0)
					maxAccX = var0;
				if (maxAccY < var1)
					maxAccY = var1;
				if (maxAccZ < var2)
					maxAccZ = var2;
				//최대가속도      최대값  20인듯
				maxAcc.setText("X : " + maxAccX + ", Y : " + maxAccY + ", Z : "	+ maxAccZ);

				//Log.e(TAG, "TYPE_ACCELEROMETER : x = " + var0 + " , y = "+ var1 + " , z = " + var2);
				break;
			case Sensor.TYPE_ORIENTATION:	//방향
				ori.setText("x = " + var0 + " , y = " + var1 + " , z = " + var2);
				//Log.e(TAG, "TYPE_ORIENTATION : x = " + var0 + " , y = " + var1	+ " , z = " + var2);
				break;
			case Sensor.TYPE_LIGHT:			//밝기
				lig.setText("x = " + var0 + " , y = " + var1 + " , z = " + var2);
				//Log.e(TAG, "TYPE_LIGHT : x = " + var0 + " , y = " + var1	+ " , z = " + var2);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD://자기장
				mag.setText("x = " + var0 + " , y = " + var1 + " , z = " + var2);
				//Log.e(TAG, "TYPE_MAGNETIC_FIELD : x = " + var0 + " , y = "+ var1 + " , z = " + var2);
				break;
			case Sensor.TYPE_PRESSURE:		//압력
				pre.setText("x = " + var0 + " , y = " + var1 + " , z = " + var2);
				//Log.e(TAG, "TYPE_PRESSURE : x = " + var0 + " , y = " + var1	+ " , z = " + var2);
				break;
			case Sensor.TYPE_PROXIMITY:		//근접센서
				prox.setText( String.valueOf(var0));
				//Log.e(TAG, "TYPE_PROXIMITY : x = " + var0 + " , y = " + var1+ " , z = " + var2);
				break;
			case Sensor.TYPE_TEMPERATURE:	//온도
				temp.setText("x = " + var0 + " , y = " + var1 + " , z = "+ var2);
				//Log.e(TAG, "TYPE_TEMPERATURE : x = " + var0 + " , y = " + var1	+ " , z = " + var2);
				break;
			}
		}
	}
}