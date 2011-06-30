package mrsohn.samplecode.audioTest;

/*
 * The application needs to have the permission to write to external storage
 * if the output file is written to the external storage, and also the
 * permission to record audio. These permissions must be set in the
 * application's AndroidManifest.xml file, with something like:
 *
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 * <uses-permission android:name="android.permission.RECORD_AUDIO" />
 *
 */
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Bundle;
import android.os.Environment;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.util.Log;
import android.media.MediaRecorder;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.Calendar;


public class AudioRecordTest extends Activity {
	private Context context;
	
    private static final String LOG_TAG = "AudioRecordTest";
    
//    private static String mFileName = null;

    private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;

    private PlayButton   mPlayButton = null;
    private MediaPlayer   mPlayer = null;
    
    private Calendar cal = Calendar.getInstance( );
    private String mFileName = String.format("%04d-%02d-%02d%02d%02d%02d",
								            cal.get(Calendar.YEAR),
								            (cal.get(Calendar.MONTH) + 1),
								            cal.get(Calendar.DAY_OF_MONTH),
								            cal.get(Calendar.HOUR_OF_DAY),
								            cal.get(Calendar.MINUTE),
								            cal.get(Calendar.SECOND));

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    public String startRecording() {
//        mRecorder = new MediaRecorder();
////        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//        mRecorder.setAudioEncoder(MediaRecorder.AudioSource.MIC);
//        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//        mRecorder.setOutputFile(mFileName);
//        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    	  mRecorder = new MediaRecorder();
    	  mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);			//입력소스 구성
//    	  mRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
    	  mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);	//출력포멧 설정
    	  mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);		//인코더 지정
    	  mRecorder.setOutputFile(mFileName);								//저장될 파일명
    	  try {
    		  mRecorder.prepare();	//레코딩 준비
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mRecorder.start();			//레코딩 시작
		
		return mFileName;
		
       
    }

    public void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    class RecordButton extends Button {
        boolean mStartRecording = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    setText("Stop recording");
                } else {
                    setText("Start recording");
                }
                mStartRecording = !mStartRecording;
            }
        };

        public RecordButton(Context ctx) {
            super(ctx);
            setText("Start recording");
            setOnClickListener(clicker);
        }
    }

    class PlayButton extends Button {
        boolean mStartPlaying = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onPlay(mStartPlaying);
                if (mStartPlaying) {
                    setText("Stop playing");
                } else {
                    setText("Start playing");
                }
                mStartPlaying = !mStartPlaying;
            }
        };

        public PlayButton(Context ctx) {
            super(ctx);
            setText("Start playing");
            setOnClickListener(clicker);
        }
    }

    public AudioRecordTest() {
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.mp3";
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        LinearLayout ll = new LinearLayout(this);
        mRecordButton = new RecordButton(this);
        ll.addView(mRecordButton,
            new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0));
        mPlayButton = new PlayButton(this);
        ll.addView(mPlayButton,
            new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0));
        setContentView(ll);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}