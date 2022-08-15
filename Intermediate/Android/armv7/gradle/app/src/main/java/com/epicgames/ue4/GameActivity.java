// Copyright Epic Games, Inc. All Rights Reserved.
//This file needs to be here so the "ant" build step doesnt fail when looking for a /src folder.

package com.epicgames.ue4;

import android.app.NotificationManager;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.lang.Override;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.BreakIterator;
import java.util.zip.Inflater;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Runnable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import java.io.Writer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import android.annotation.TargetApi;

import android.app.Activity;
import android.app.NativeActivity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import android.os.Vibrator;
import android.os.SystemClock;
import android.os.Looper;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.method.PasswordTransformationMethod;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.IntentSender.SendIntentException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.FeatureInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.content.pm.PackageInfo;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import android.media.AudioManager;
import android.util.DisplayMetrics;

import android.view.DisplayCutout;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.Display;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.text.TextUtils;

import android.media.AudioManager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.Games;
import com.google.android.apps.internal.games.memoryadvice.MemoryAdvisor;

import com.google.android.gms.plus.Plus;

import com.google.vr.sdk.samples.permission.PermissionHelper;

import java.nio.charset.StandardCharsets;
import java.net.URL;
import java.net.URLEncoder;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import com.epicgames.ue4.GooglePlayLicensing;

// Console commands listener, only for debug builds
import com.epicgames.ue4.ConsoleCmdReceiver;

import android.os.Build;

// TODO: use the resources from the UE4 lib project once we've got the packager up and running
//import com.epicgames.ue4.R;

import com.epicgames.ue4.DownloadShim;

// used in new virtual keyboard
import android.view.inputmethod.InputMethodManager;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ViewTreeObserver;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.util.AttributeSet;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.BroadcastReceiver;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import com.epicgames.ue4.GooglePlayStoreHelper;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




//Extending NativeActivity so that this Java class is instantiated
//from the beginning of the program.  This will allow the user
//to instantiate other Java libraries from here, that the user
//can then use the functions from C++
//NOTE -- This class is not necessary for the UnrealEngine C++ code
//  to startup, as this is handled through the base NativeActivity class.
//  This class's functionality is to provide a way to instantiate other
//  Java libraries at the startup of the program and store references 
//  to them in this class.

public class GameActivity extends NativeActivity implements SurfaceHolder.Callback2,
															GoogleApiClient.ConnectionCallbacks,
															GoogleApiClient.OnConnectionFailedListener,
															SensorEventListener,
															Logger.ILoggerCallback,

															ComponentCallbacks2
{
	public int VersionCode = 0;
	private boolean bAllowIMU = true;
	private SensorManager sensorManager;
	private Sensor accelerometer;
	private Sensor magnetometer;
	private Sensor gyroscope;
	static boolean first_acceleration_sample = true;
	static final float SampleDecayRate = 0.85f;

	private Rect safezone = new Rect(0, 0, 0, 0);
	private RectF safezoneF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

	private final float[] rotationMatrix = new float[9];
	private final float[] orientationAngles = new float[3];

	static float[] current_accelerometer = new float[]{0, 0, 0};
	static float[] current_gyroscope = new float[]{0, 0, 0};
	static float[] current_magnetometer = new float[]{0, 0, 0};

	static float[] filtered_gravity = new float[]{0, 0, 0};
	static float[] last_gravity = new float[]{0, 0, 0};
	static float[] last_tilt = new float[]{0, 0, 0};

	// active motion state to return to application on request
	boolean bSensorDataUpdated = false;
	float[] current_tilt = new float[]{0, 0, 0};
	static float[] current_rotation_rate = new float[]{0, 0, 0};
	static float[] current_gravity = new float[]{0, 0, 0};
	static float[] current_acceleration = new float[]{0, 0, 0};

	public static Logger Log = new Logger("UE4", "GameActivity");

	// From cpufeatures.h AndroidCpuFamily enum
	private static final int ANDROID_CPU_FAMILY_UNKNOWN = 0;
	private static final int ANDROID_CPU_FAMILY_ARM = 1;
	private static final int ANDROID_CPU_FAMILY_X86 = 2;
	private static final int ANDROID_CPU_FAMILY_MIPS = 3;
	private static final int ANDROID_CPU_FAMILY_ARM64 = 4;
	private static final int ANDROID_CPU_FAMILY_X86_64 = 5;
	private static final int ANDROID_CPU_FAMILY_MIPS64 = 6;

	// For GetNetworkConnectionType
	private static final int CONNECTION_TYPE_NONE = 0;
	private static final int CONNECTION_TYPE_AIRPLANEMODE = 1;
	private static final int CONNECTION_TYPE_ETHERNET = 2;
	private static final int CONNECTION_TYPE_CELL = 3;
	private static final int CONNECTION_TYPE_WIFI = 4;
	private static final int CONNECTION_TYPE_WIMAX = 5;
	private static final int CONNECTION_TYPE_BLUETOOTH = 6;
	
	public static final int DOWNLOAD_ACTIVITY_ID = 80001; // so we can identify the activity later
	public static final int DOWNLOAD_NO_RETURN_CODE = 0; // we didn't get a return code - will need to log and debug as this shouldn't happen
	public static final int DOWNLOAD_FILES_PRESENT = 1;  // we already had the files we needed
	public static final int DOWNLOAD_COMPLETED_OK = 2; // downloaded ok (practically the same as above)
	public static final int DOWNLOAD_USER_QUIT = 3;    // user aborted the download
	public static final int DOWNLOAD_FAILED = 4;
	public static final int DOWNLOAD_INVALID = 5;
	public static final int DOWNLOAD_NO_PLAY_KEY = 6;
	public static final String DOWNLOAD_RETURN_NAME = "Result";

	private static final int CONFIGRULES_STATE_RUN = 0;
	private static final int CONFIGRULES_STATE_EXECTRUE = 1;
	private static final int CONFIGRULES_STATE_FINDELSE = 2;
	private static final int CONFIGRULES_STATE_EXECFALSE = 3;
	private static final int CONFIGRULES_STATE_FINDEND = 4;

	public static enum VirtualKeyboardCommand { VK_CMD_NONE, VK_CMD_SHOW, VK_CMD_HIDE };
	public static VirtualKeyboardCommand lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
	public static final int lastVirtualKeyboardCommandDelay = 200;
	public static final int checkLastVirtualKeyboardCommandDelay = 500;
	public static final boolean bSamsungDevice = android.os.Build.MANUFACTURER.equals("samsung");
	
	static GameActivity _activity = null;
	static Bundle _bundle;
	static Bundle _extrasBundle;

	private HandlerThread memoryHandlerThread;
	private Handler memoryHandler;
	private Runnable memoryRunnable;
	public int UsedMemory;

	public String InternalFilesDir;
	public String ExternalFilesDir;

	protected Dialog mSplashDialog;
	private int noActionAnimID = -1;

	protected ProgressDialog mProgressDialog;

	// Commandline arguments and flags
	private boolean bHaveParsedCommandline = false;
	public String CommandLineFull = "";
	public ArrayList<String> CommandLineArguments = new ArrayList<String>();
	public HashMap<String, String> CommandLineFlags = new HashMap<String, String>();

	// Engine branch from manifest
	String EngineBranch = "UE4";

	// Project versiom from manifest
	String ProjectVersion = "1.0.0";

	// Console
	private static final String CONSOLE_SPINNER_ITEMS[] = {"Common Console Commands", "stat FPS", "stat Anim","stat OpenGLRHI","stat VulkanRHI","stat DumpEvents","stat DumpFrame",
		"stat DumpHitches","stat Engine","stat Game","stat Grouped","stat Hitches","stat InitViews","stat LightRendering",
		"stat Memory","stat Particles","stat SceneRendering","stat SceneUpdate","stat ShadowRendering","stat Slow",
		"stat Streaming","stat StreamingDetails","stat Unit","stat UnitGraph", "stat StartFile", "stat StopFile", "GameVer", "show PostProcessing", "stat AndroidCPU"};

	AlertDialog consoleAlert;
	LinearLayout consoleAlertLayout;
	Spinner consoleSpinner;
	ConsoleKeyboardInput consoleInputBox;

	// remember screensaver state to restore
	private boolean bKeepScreenOn = false;
	
	// number of times screen capturing has been disabled
	private int NumTimesScreenCaptureDisabled = 0;

	// Virtual keyboard
	AlertDialog virtualKeyboardAlert;
	EditText virtualKeyboardInputBox;
	String virtualKeyboardPreviousContents;

	//virtual keyboard input - custom EditText
	VirtualKeyboardInput newVirtualKeyboardInput;

	//layout for displaying virtual keyboard input
	private LinearLayout virtualKeyboardLayout;

	//container for SurfaceView and virtual keyboard input
	private FrameLayout containerFrameLayout;

	//handler for virtual keyboard show/hide events
	private Handler virtualKeyboardHandler;

	// Keep a reference to the main content view so we can bring up the virtual keyboard without an editbox
	private View mainView;
	private boolean bKeyboardShowing;

	private View mainDecorView;
	private Rect mainDecorViewRect;

	// Console commands receiver
	ConsoleCmdReceiver consoleCmdReceiver;

	// default the PackageDataInsideApk to an invalid value to make sure we don't get it too early
	private static int PackageDataInsideApkValue = -1;
	private static int HasOBBFiles = -1;
	
	// depthbuffer preference from manifest
	int DepthBufferPreference = 0;
	
	/** AssetManger reference - populated on start up and used when the OBB is packed into the APK */
	private AssetManager			AssetManagerReference;
	
	private GoogleApiClient googleClient;

	// layout required by popups, e.g ads, native controls
	LinearLayout activityLayout;

	/** Request code to use when launching the Google Services resolution activity */
    private static final int GOOGLE_SERVICES_REQUEST_RESOLVE_ERROR = 1001;

	/** Unique tag for the error dialog fragment */
    private static final String DIALOG_ERROR = "dialog_error";

	/** Unique ID to identify Google Play Services error dialog */
	private static final int PLAY_SERVICES_DIALOG_ID = 1;
	
	private static String appPackageName = "";

	/** Check to see if we have all the files */
	private boolean HasAllFiles = false;
	
	/** Check to see if we should be verifying the files once we have them */
	public boolean VerifyOBBOnStartUp = false;

	/** Use ExternalFilesDir for UE4Game files */
    private boolean UseExternalFilesDir = false;

	/** Make log files public */
    private boolean PublicLogFiles = false;

	/** Flag to ensure we have finished startup before allowing nativeOnActivityResult to get called */
	private boolean InitCompletedOK = false;

	private boolean bConfigRulesError = false;
	private String ConfigRulesStatus = "UNSET";

	/** Dialog for force game dialog */
	private AlertDialog ForceGameDialog = null;

	/** Flag to force game to end with error on resume */
	private boolean bForceGameEndWithError = false;

	/** Flag to force game to show warning on resume */
	private boolean bForceGameEndWithWarning = false;

	/** Text to show the error state for bForceGameEndWithError */
	private String ForceExitCaption = "";
	private String ForceExitMessage = "";
	private String ForceExitQuitButtonText = "";
	private String ForceExitHelpButtonText = "";
	private String ForceExitContinueButtonText = "";
	private String ForceExitUpdateButtonText = "";
	private String ForceExitLink = "";
	
	private boolean SplashScreenLaunch = false;
	private boolean UseDisplayCutout = false;
	private boolean ShouldHideUI = false;

	/** Whether this application is for distribution */
	private boolean IsForDistribution = false;
	

	/** Application build configuration */
	private String BuildConfiguration = "";

	/** Whether we are in VRMode */
	private boolean IsInVRMode = false;

	/** Whether this application uses VR keyboard as input */
	private boolean bUsesVrKeyboard = false;

	/** Used for SurfaceHolder.setFixedSize buffer scaling workaround on early Amazon devices and some others */
	private boolean bUseSurfaceView = false;
	private SurfaceView MySurfaceView;
	private int DesiredHolderWidth = 0;
	private int DesiredHolderHeight = 0;

	/** Discovered Vulkan Version and Level from getSystemAvailableFeatures() */
	private int VulkanVersion = 0;
	private int VulkanLevel = 0;
	private String VulkanVersionString = "0.0.0";
	private boolean bSupportsVulkan = false;

	/** OpenGL information */
	public String OpenGLVendor = "";
	public String OpenGLDevice = "";
	public String OpenGLVersion = "";
	public String OpenGLDriver = "";
	public String TextureFormats = "ETC1";
	public boolean bSupportsFloatingPointRenderTargets = false;
	private String EGLErrorStatus = "UNSET";
	
	/** Flag for not officially supported devices */
	public static boolean bSupportedDevice = true;

	/** Used for LocalNotification support*/
	private boolean localNotificationAppLaunched = false;
	private String	localNotificationLaunchActivationEvent = "";
	private int		localNotificationLaunchFireDate = 0;
	
	enum EAlertDialogType
	{
		None,
		Console,
		Keyboard
	}
	private EAlertDialogType CurrentDialogType = EAlertDialogType.None;
	
	public boolean IsInVRMode()
	{
		return IsInVRMode;
	}

	/** Access singleton activity for game. **/
	public static GameActivity Get()
	{
		return _activity;
	}
	
	/**
	Get the SDK level of the OS we are running in.
	We do this instead of accessing the SDK_INT
	with JNI from C++ as the new ART runtime seems to have
	problems dynamically finding/loading static inner classes.
	*/
	public static final int ANDROID_BUILD_VERSION = android.os.Build.VERSION.SDK_INT;
	
	private StoreHelper IapStoreHelper;
	
	private MemoryAdvisor MemAdvisor;
	private static final int MemoryAdvisorPollDelayMs = 5000;
	private static final int MemoryAdvisorStateDecreaseDelayMs = 10000;
	private static final int ProcessMemoryInfoPollDelayMs = 10000;
	private long LastMemoryInfoPollTime;
	private long LastMemAdvisorStateUpdateTime;
	private MemoryAdvisor.MemoryState MemState = MemoryAdvisor.MemoryState.UNKNOWN;

	public MemoryAdvisor GetMemoryAdvisor()
	{
		return MemAdvisor;
	}

	/** Implement this if app wants to handle IAB activity launch. For e.g use DaydreamApi for transitions **/
	GooglePlayStoreHelper.PurchaseLaunchCallback purchaseLaunchCallback = null;

	public GooglePlayStoreHelper.PurchaseLaunchCallback getPurchaseLaunchCallback()
	{
		return purchaseLaunchCallback;
	}
          public void AndroidThunkJava_RegisterForRemoteNotifications()
          {
          }
          public void AndroidThunkJava_UnregisterForRemoteNotifications()
          {
          }
        	// for GooglePAD
	public boolean AndroidThunkJava_GooglePAD_Available()
	{
		return false;
	}
			/** Whether this application was packaged for Oculus Mobile or not */
			public boolean PackagedForOculusMobile = false;

			// check the manifest to determine if we are a Oculus Mobile application
			public boolean AndroidThunkJava_IsOculusMobileApplication()
			{
			return PackagedForOculusMobile;
			}


	@Override
	public void onStart()
	{
		super.onStart();
		
		if (!BuildConfiguration.equals("Shipping"))
		{
			// Create console command broadcast listener
			Log.debug( "Creating console command broadcast listener");
			consoleCmdReceiver = new ConsoleCmdReceiver(this);
			registerReceiver(consoleCmdReceiver, new IntentFilter(Intent.ACTION_RUN));
		}

		Log.debug("==================================> Inside onStart function in GameActivity");
	}

	public int getDeviceDefaultOrientation() 
	{
		// WindowManager windowManager =  (WindowManager) getSystemService(WINDOW_SERVICE);
		WindowManager windowManager =  getWindowManager();

		Configuration config = getResources().getConfiguration();

		int rotation = windowManager.getDefaultDisplay().getRotation();
		if ( ((rotation == android.view.Surface.ROTATION_0 || rotation == android.view.Surface.ROTATION_180) &&
				config.orientation == Configuration.ORIENTATION_LANDSCAPE)
			|| ((rotation == android.view.Surface.ROTATION_90 || rotation == android.view.Surface.ROTATION_270) &&    
				config.orientation == Configuration.ORIENTATION_PORTRAIT)) 
		{
			return Configuration.ORIENTATION_LANDSCAPE;
		}
		else 
		{
			return Configuration.ORIENTATION_PORTRAIT;
		}
	}

	public int getCurrentDeviceRotationDegree() 
	{
		// onConfigurationChanged won't be called if orientation changes from landscape/portrait to reverse landscape/portrait
		// use this function instead of caching DeviceRotation
		int orientation = AndroidThunkJava_GetDeviceOrientation();

		switch (orientation)
		{
			case Surface.ROTATION_0:	return 0;
			case Surface.ROTATION_90:	return 90;
			case Surface.ROTATION_180:	return 180;
			case Surface.ROTATION_270:	return 270;
		}

		return 0;
	}

	private int getResourceId(String VariableName, String ResourceName, String PackageName)
	{
		try {
			return getResources().getIdentifier(VariableName, ResourceName, PackageName);
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
	}

	private String getResourceStringOrDefault(String PackageName, String ResourceName, String DefaultString)
	{
		int resourceId = getResourceId(ResourceName, "string", PackageName);
		return (resourceId < 1) ? DefaultString : getString(resourceId);
	}

    public static List<String> getInstalledPackages(final Context context)
    {
        List<String> result = new ArrayList<>();
        final PackageManager pm = context.getPackageManager();
        try
		{
            List<PackageInfo> apps = pm.getInstalledPackages(0);
            for (PackageInfo packageInfo : apps) {
                result.add(packageInfo.packageName);
            }
            return result;
        }
		catch (Exception ignored)
		{
            // could have failed depending on bugs in Android version
        }

        // use fallback
        BufferedReader bufferedReader = null;
        try
		{
            Process process = Runtime.getRuntime().exec("pm list packages");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String packageName = line.substring(line.indexOf(':') + 1);
                result.add(packageName);
            }
            bufferedReader.close();
            process.waitFor();
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
        if (bufferedReader != null)
        {
            try
			{
                bufferedReader.close();
            }
            catch (Exception e) {
            }
        }
        return result;
    }

    public boolean AndroidThunkJava_IsPackageInstalled(String packagename)
	{
        List<String> packages = getInstalledPackages(getApplicationContext());
        return packages.contains(packagename);
    }

	public String AndroidThunkJava_GetCommandLine()
	{
		String commandLine = "";
		
		return commandLine;
	}

	private BufferedReader TryOpenFileReader(String Filename)
	{
		BufferedReader reader = null;
		File file = new File(Filename);

		if (file.exists())
		{
			try
			{
				reader = new BufferedReader(new FileReader(file));
			}
			catch (IOException ie)
			{
				reader = null;
			}
		}
		return reader;
	}

	public void ParseCommandline(String ProjectName, boolean bUseExternalFilesDir)
	{
		if (bHaveParsedCommandline)
		{
			return;
		}
		bHaveParsedCommandline = true;
		
		String tempCommandLine = AndroidThunkJava_GetCommandLine();
		if(!TextUtils.isEmpty(tempCommandLine)) {
			Log.debug("Using alternative commandline source");
			// remember full commandline for regex checks by configrules
			CommandLineFull = tempCommandLine;
			parseCommandLineParams(tempCommandLine);
			return;
		}

		BufferedReader reader = null;

		// determine the proper place to look for UE4CommandLine.txt as override outside APK
		String BaseDirectory = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
		if (bUseExternalFilesDir)
		{
			BaseDirectory = getExternalFilesDir(null).getAbsolutePath();
			if (nativeIsShippingBuild())
			{
				BaseDirectory = getFilesDir().getAbsolutePath();
			}
		}

		// first look for an override in the project directory
		String filename = BaseDirectory + "/UE4Game/" + ProjectName + "/UE4CommandLine.txt";
		reader = TryOpenFileReader(filename);
		if (reader == null)
		{
			filename = BaseDirectory + "/UE4Game/" + ProjectName + "/ue4commandline.txt";
			reader = TryOpenFileReader(filename);
		}

		// then look in assets in APK
		if (reader == null)
		{
			try
			{
				InputStream stream = AssetManagerReference.open("UE4CommandLine.txt");
				reader = new BufferedReader(new InputStreamReader(stream));
				Log.debug("Using APK commandline");
			}
			catch (FileNotFoundException fe)
			{
			}
			catch (IOException ie)
			{
			}
		} else {
			Log.debug("Using commandline from: " + filename);
		}

		// parse the commandline
		if (reader != null)
		{
			try
			{
				String line = reader.readLine();
				if (line != null)
				{
					line = line.trim();
					if (line.length() > 0)
					{
						// remember full commandline for regex checks by configrules
						CommandLineFull = line;
						parseCommandLineParams(line);
					}
				}
			}
			catch (IOException ie)
			{
				Log.debug("failed to read commandline: " + ie);
			}
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException ie)
				{
				}
			}
		}
	}

	private void parseCommandLineParams(String line) {
		Log.debug("Parsing commandline: " + line);

		// parse the line
		ArrayList<String> sets = ParseSegments(line, " ", "\"", "\"");
		for (String set : sets)
		{
			String argument = set.trim();

			if (argument.startsWith("-"))
			{
				argument = argument.substring(1);
				ArrayList<String> keyvalues = ParseSegments(argument, "=", "\"", "\"");
				if (keyvalues.size() == 2)
				{
					CommandLineFlags.put(keyvalues.get(0).toLowerCase(), RemoveSurrounds(keyvalues.get(1), "\"", "\""));
				}
				else
				{
					CommandLineFlags.put(argument.toLowerCase(), "");
				}
			}
			else
			{
				CommandLineArguments.add(RemoveSurrounds(argument, "\"", "\""));
			}
		}
	}

	public static byte[] getByteArrayFromFile(String filename)
	{
		try
		{
			File file = new File(filename);
			if (file.exists())
			{
				long fileLength = file.length();
				byte[] buffer = new byte[(int)fileLength];
				InputStream inStream = new FileInputStream(file);
				inStream.read(buffer);
				inStream.close();
				return buffer;
			}
		}
		catch (IOException e)
		{
		}
		return null;
	}

	private byte[] getByteArrayFromAssets(String filename)
	{
		InputStream stream = null;
		try
		{
			stream = AssetManagerReference.open("configrules.bin.png");
			byte[] fileBytes = new byte[stream.available()];
			stream.read(fileBytes);
			stream.close();
			return fileBytes;
		}
		catch (FileNotFoundException fe)
		{
		}
		catch (IOException ie)
		{
		}
		return null;
	}

	private int getConfigRulesVersion(byte[] bytesToDecompress)
	{
		if (bytesToDecompress == null)
		{
			return -1;
		}

		int headerSize = 2 + 4 + 4;
		int sizeCompressed = bytesToDecompress.length - headerSize;
		if (sizeCompressed < 0)
		{
			return -1;
		}

		ByteBuffer buffer = ByteBuffer.wrap(bytesToDecompress);
		int signature = buffer.getShort();
		if (signature != 0x39d8)
		{
			return -1;
		}
		return buffer.getInt();
	}

	private SecretKey generateAESKey(String password)
	{
		byte[] salt = new byte[] { 0x23, 0x71, (byte)0xd3, (byte)0xa3, 0x30, 0x71, 0x63, (byte)0xe3 };
		try
		{
			SecretKey secret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(password.toCharArray(), salt, 1000, 128));
			return new SecretKeySpec(secret.getEncoded(), "AES");
		}
		catch (Exception e)
		{
		}
		return new SecretKeySpec(salt, "AES");
	}

	private InputStream getConfigRulesDecompressed(byte[] bytesToDecompress)
	{
		if (bytesToDecompress == null)
		{
			return null;
		}

		int headerSize = 2 + 4 + 4;
		int sizeCompressed = bytesToDecompress.length - headerSize;
		if (sizeCompressed < 0)
		{
			return null;
		}

		ByteBuffer buffer = ByteBuffer.wrap(bytesToDecompress);

		// validate signature
		int signature = buffer.getShort();
		if (signature != 0x39d8)
		{
			return null;
		}
		int version = buffer.getInt();
		int sizeUncompressed = buffer.getInt();
		byte[] bytesDecompressed = new byte[sizeUncompressed];

		// decrypt if key provided
		try
		{
			Field keyField = this.getClass().getDeclaredField("CONFIGRULES_KEY");
			String key = (String)keyField.get(this);

			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, generateAESKey(key));
			byte[] decrypted = cipher.doFinal(bytesToDecompress, headerSize, sizeCompressed);
			sizeCompressed = decrypted.length;

			// decompress it
			Inflater inflater = new Inflater();
			inflater.setInput(decrypted, 0, sizeCompressed);
			int resultLength = inflater.inflate(bytesDecompressed);
			inflater.end();
			if (resultLength != sizeUncompressed)
			{
				return null;
			}
		}
		catch (Exception e)
		{
			// decompress it without decrypting
			try
			{
				Inflater inflater = new Inflater();
				inflater.setInput(bytesToDecompress, headerSize, sizeCompressed);
				int resultLength = inflater.inflate(bytesDecompressed);
				inflater.end();
				if (resultLength != sizeUncompressed)
				{
					return null;
				}
			}
			catch (Exception ee)
			{
				return null;
			}
		}

		// now provide a BufferedReader for final buffer
		InputStream inputStream = null;
		try
		{
			inputStream = new ByteArrayInputStream(bytesDecompressed);
			return inputStream;
		}
		catch (Exception e)
		{
        }
		return null;
	}

	// returns InputStream to most up to date version of configrules
	private InputStream getConfigRulesStream(String ProjectName)
	{
		ConfigRulesStatus = "";

		byte[] configBytesAssets = getByteArrayFromAssets("configrules.bin.png");
		byte[] configBytesInternal = getByteArrayFromFile(InternalFilesDir + "configrules.bin.png");
		byte[] configBytesExternal = getByteArrayFromFile(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/UE4Game/" + ProjectName + "/configrules.bin.png");

		int assetsVersion = getConfigRulesVersion(configBytesAssets);
		int internalVersion = getConfigRulesVersion(configBytesInternal);
		int externalVersion = getConfigRulesVersion(configBytesExternal);

		// is there one at all?
		if (assetsVersion == -1 && internalVersion == -1 && externalVersion == -1)
		{
			ConfigRulesStatus = "Not found. ";
			return null;
		}

		InputStream result = null;
		if (CommandLineFlags.containsKey("noconfigrulesdownload"))
		{
			result = getConfigRulesDecompressed(configBytesAssets);
		}
		else if (assetsVersion >= internalVersion && assetsVersion >= externalVersion)
		{
			result = getConfigRulesDecompressed(configBytesAssets);
		}
		else if (internalVersion >= assetsVersion && internalVersion >= externalVersion)
		{
			result = getConfigRulesDecompressed(configBytesInternal);
			if (result == null && assetsVersion != -1)
			{
				result = getConfigRulesDecompressed(configBytesAssets);
			}
		}
		else
		{
			result = getConfigRulesDecompressed(configBytesExternal);
			if (result == null && internalVersion != -1)
			{
				result = getConfigRulesDecompressed(configBytesInternal);
			}
			if (result == null && assetsVersion != -1)
			{
				result = getConfigRulesDecompressed(configBytesAssets);
			}
		}
		if (result == null)
		{
			ConfigRulesStatus = "failed to find config rules. ";
			bConfigRulesError = true;
		}
		return result;
	}

	// returns parsed /proc/cpuinfo with per processor fields prefix with id: (ex. 3:Features is Features for 4th CPU).
	// processorCount returns the total processor count found referenced.
	private Map<String, String> getCpuInfo()
	{
		Map<String, String> cpuInfo = new HashMap<String, String>();
		File file = new File("/proc/cpuinfo");
		if (file.exists())
		{
			BufferedReader reader = null;
			try
			{
				reader = new BufferedReader(new FileReader(file));
				String line;
				int processorId = -1;
				int processorCount = 0;
				while ((line = reader.readLine()) != null)
				{
					if (line.length() > 1)
					{
						String[] keyvalue = line.split(": ");
						if (keyvalue.length > 1)
						{
							keyvalue[0] = keyvalue[0].trim();
							keyvalue[1] = keyvalue[1].trim();

							if (keyvalue[0].equals("processor"))
							{
								try
								{
									processorId = Integer.parseInt(keyvalue[1]);
									processorCount = processorId > processorCount ? processorId : processorCount;
								}
								catch (NumberFormatException ne)
								{
									processorId = -1;
								}
							}
							else
							{
								cpuInfo.put((processorId == -1 ? "" : processorId + ":") + keyvalue[0], keyvalue[1]);
							}
						}
					}
					else
					{
						processorId = -1;
					}
				}
				processorCount++;
				cpuInfo.put("processorCount", Integer.toString(processorCount));
			}
			catch (IOException ie)
			{
				Log.debug("failed to read /proc/cpuinfo: " + ie);
			}
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException ie)
				{
				}
			}
		}
		else
		{
			Log.debug("failed to open /proc/cpuinfo!");
		}
		return cpuInfo;
	}

	private String getProp(String property)
	{
		// first try SystemProperties reflection
		try
		{
			java.lang.reflect.Method get = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
			String propValue = (String)get.invoke(null, property);
			if (propValue != null)
			{
				return propValue;
			}
			return "";
		}
		catch (Exception e)
		{
		}

		// fall back to getprop command
		Process process = null;
		BufferedReader reader = null;
		String result = "";

		try
		{
			process = new ProcessBuilder().command("/system/bin/getprop", property).redirectErrorStream(true).start();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = reader.readLine();
			result = (line == null) ? "" : line;
		}
		catch (Exception e)
		{
			Log.debug("Unable to use getprop: " + e);
		}
		if (reader != null)
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
			}
		}
		if (process != null)
		{
			process.destroy();
		}
		return result;
	}

	private void getGraphicsInformation()
    {
		int initialError = EGL14.eglGetError();
		EGLErrorStatus = (initialError == EGL14.EGL_SUCCESS) ? "" : "InitialEGLError = " + initialError + " ";

		EGLDisplay display = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);
		EGLErrorStatus += (display != EGL14.EGL_NO_DISPLAY) ? "" : "eglGetDisplay = " + EGL14.eglGetError() + " ";

		int[] version = new int[2];
		boolean bEglInitialized = EGL14.eglInitialize(display, version, 0, version, 1);
		EGLErrorStatus += (bEglInitialized) ? "" : "eglInitialize = " + EGL14.eglGetError() + " ";

		// find a config from EGL
		int[] configAttr = {EGL14.EGL_COLOR_BUFFER_TYPE, EGL14.EGL_RGB_BUFFER,
			EGL14.EGL_LEVEL, 0,
			EGL14.EGL_RENDERABLE_TYPE, EGL14.EGL_OPENGL_ES2_BIT,
			EGL14.EGL_SURFACE_TYPE, EGL14.EGL_PBUFFER_BIT,
			EGL14.EGL_NONE};
		EGLConfig[] configs = new EGLConfig[1];
		int[] numConfig = new int[1];
		EGL14.eglChooseConfig(display, configAttr, 0, configs, 0, 1, numConfig, 0);
		if (numConfig[0] == 0)
		{
			EGLErrorStatus += "eglChooseConfig = " + EGL14.eglGetError() + " ";
			Log.debug("Did not find an EGL config");
			return;
		}
		EGLConfig config = configs[0];

		// small surface just to make a context
		int[] surfAttr = {EGL14.EGL_WIDTH, 8, EGL14.EGL_HEIGHT, 8, EGL14.EGL_NONE};
		EGLSurface surface = EGL14.eglCreatePbufferSurface(display, config, surfAttr, 0);
		EGLErrorStatus += (surface != EGL14.EGL_NO_SURFACE) ? "" : "eglCreatePbufferSurface = " + EGL14.eglGetError() + " ";

		// create the context (ES 2)
		int[] contextAttr = {EGL14.EGL_CONTEXT_CLIENT_VERSION, 2, EGL14.EGL_NONE};
		EGLContext context = EGL14.eglCreateContext(display, config, EGL14.EGL_NO_CONTEXT, contextAttr, 0);
		EGLErrorStatus += (context != EGL14.EGL_NO_CONTEXT) ? "" : "eglCreateContext = " + EGL14.eglGetError() + " ";
		
		// make context to gather information
		boolean bMakeCurrent = EGL14.eglMakeCurrent(display, surface, surface, context);
		EGLErrorStatus += bMakeCurrent ? "" : "eglMakeCurrent = " + EGL14.eglGetError() + " ";

		// grab info now
		String Extensions = GLES20.glGetString(GLES20.GL_EXTENSIONS);
		OpenGLVendor = GLES20.glGetString(GLES20.GL_VENDOR);
		OpenGLDevice = GLES20.glGetString(GLES20.GL_RENDERER);
		OpenGLDriver = GLES20.glGetString(GLES20.GL_VERSION);
		boolean bES30Support = OpenGLDriver.contains("OpenGL ES 3.");

		// write any gl error to status
		int finalGLESError = GLES20.glGetError();
		EGLErrorStatus += finalGLESError == GLES20.GL_NO_ERROR ? "getGraphicsInformation completed. " : "gl error = " + finalGLESError;

		// tear it down
		EGL14.eglMakeCurrent(display, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
		EGL14.eglDestroySurface(display, surface);
		EGL14.eglDestroyContext(display, context);
		EGL14.eglTerminate(display);

		// Common GPU types
		boolean bIsNvidiaBased = OpenGLDevice.contains("NVIDIA");
		boolean bIsPowerVRBased = OpenGLDevice.contains("PowerVR");
		boolean bIsAdrenoBased = OpenGLDevice.contains("Adreno");
		boolean bIsMaliBased = OpenGLDevice.contains("Mali");
		boolean bIsVideoCoreBased = OpenGLDevice.contains("VideoCore");

		// match up vendors
		//if (bIsNvidiaBased) OpenGLVendor = "Nvidia";
		//else if (bIsPowerVRBased) OpenGLVendor = "ImageTec";
		//else if (bIsAdrenoBased) OpenGLVendor = "Qualcomm";
		//else if (bIsMaliBased) OpenGLVendor = "ARM";
		//else if (bIsVideoCoreBased) OpenGLVendor = "Broadcom";
		//else OpenGLVendor = "Unknown";

		// extract the OpenGL version
		OpenGLVersion = "";
		int index = OpenGLDriver.indexOf("OpenGL ES ");
		if (index >= 0)
		{
			OpenGLVersion = OpenGLDriver.substring(index + 10);
			index = OpenGLVersion.indexOf(" ");
			if (index > 0)
			{
				OpenGLVersion = OpenGLVersion.substring(0, index);
			}
		}

		bSupportsFloatingPointRenderTargets = Extensions.contains("GL_EXT_color_buffer_half_float")
				|| (bES30Support && Extensions.contains("GL_EXT_color_buffer_float"));

		// figure out supported texture formats from extensions
		TextureFormats = "";
		if (Extensions.contains("GL_KHR_texture_compression_astc_ldr"))
		{
			TextureFormats += "ASTC,";
		}
		if (Extensions.contains("GL_IMG_texture_compression_pvrtc"))
		{
			TextureFormats += "PVRTC,";
		}
		if (Extensions.contains("GL_NV_texture_compression_s3tc") || Extensions.contains("GL_EXT_texture_compression_s3tc"))
		{
			TextureFormats += "DXT,";
		}
		if (Extensions.contains("GL_ATI_texture_compression_atitc") || Extensions.contains("GL_AMD_compressed_ATC_texture"))
		{
			TextureFormats += "ATC,";
		}
		if (OpenGLVersion.charAt(0) >= '3')
		{
			TextureFormats += "ETC2,";
		}
		TextureFormats += "ETC1";
    }

	// removes the entry and exit from ends of the string if present and paired
	private String RemoveSurrounds(String input, String entry, String exit)
	{
		int entryLength = entry.length();
		int exitLength = exit.length();
		int inputLength = input.length();

		if (inputLength >=2 && entryLength > 0 && entryLength == exitLength)
		{
			String start = input.substring(0,1);
			String end = input.substring(inputLength-1);

			for (int index=0; index < entryLength; index++)
			{
				if (entry.substring(index, index+1).equals(start) && exit.substring(index, index+1).equals(end))
				{
					return input.substring(1, inputLength-1);
				}
			}
		}
		return input;
	}

	// returns list of strings separated by split using entry/exit as pairing sets (ex. "(" and ")").  The entry and exit characters need to be in same order
	private ArrayList<String> ParseSegments(String input, String split, String entry, String exit)
	{
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<Integer> entryStack = new ArrayList<Integer>();

		int startIndex = 0;
		int scanIndex = 0;
		int exitIndex = -1;
		int inputLength = input.length();
		while (scanIndex < inputLength)
		{
			String scan = input.substring(scanIndex, scanIndex+1);

			if (scan.equals(split) && entryStack.size() == 0)
			{
				output.add(input.substring(startIndex, scanIndex).trim());
				scanIndex++;
				startIndex = scanIndex;
				continue;
			}
			scanIndex++;

			if (scan.equals("\\"))
			{
				scanIndex++;
				continue;
			}

			if (entryStack.size() > 0 && exit.indexOf(scan) == exitIndex)
			{
				int stackLength = entryStack.size() - 1;
				entryStack.remove(stackLength);
				exitIndex = stackLength > 0 ? entryStack.get(stackLength - 1) : -1;
				continue;
			}

			int entryIndex = entry.indexOf(scan);
			if (entryIndex >= 0)
			{
				entryStack.add(entryIndex);
				exitIndex = entryIndex;
				continue;
			}
		}
		if (startIndex < inputLength)
		{
			output.add(input.substring(startIndex).trim());
		}

		return output;
	}

	private String ExpandVariables(Map<String, String> variables, String input)
	{
		String Result = input;
		int Idx;
		for (Idx = Result.indexOf("$("); Idx != -1; Idx = Result.indexOf("$(", Idx))
		{
			// Find the end of the variable name
			int EndIdx = Result.indexOf(')', Idx + 2);
			if (EndIdx == -1)
			{
				break;
			}

			// Extract the variable name from the string
			String Name = Result.substring(Idx + 2, EndIdx);

			// Find the value for it if it exists
			if (!variables.containsKey(Name))
			{
				Idx = EndIdx + 1;
				continue;
			}

			// Replace the variable, or skip past it
			Result = Result.substring(0, Idx) + variables.get(Name) + Result.substring(EndIdx + 1);
		}
		return Result;
	}

	private boolean EvaluateConditions(Map<String, String> variables, ArrayList<String> conditions, String PreviousRegexMatch)
	{
		boolean bConditionTrue = true;
		for (String condition : conditions)
		{
			String SourceType = "";
			String CompareType = "";
			String MatchString = "";

			// deal with condition group (src,cmp,match)
			ArrayList<String> groups = ParseSegments(RemoveSurrounds(condition, "(", ")"), ",", "\"", "\"");
			for (String group : groups)
			{
				ArrayList<String> keyvalue = ParseSegments(group, "=", "\"", "\"");
				if (keyvalue.size() == 2)
				{
					String key = RemoveSurrounds(keyvalue.get(0), "\"", "\"");
					String value = RemoveSurrounds(keyvalue.get(1), "\"", "\"");

					if (key.equals("SourceType"))
					{
						SourceType = value;
					}
					else if (key.equals("CompareType"))
					{
						CompareType = value;
					}
					else if (key.equals("MatchString"))
					{
						MatchString = value;
					}
				}
			}

			String Source = "";
			boolean bSourceIsCommandLine = false;
			if (SourceType.equals("SRC_PreviousRegexMatch"))
			{
				Source = PreviousRegexMatch;
			}
			else if (SourceType.equals("SRC_CommandLine"))
			{
				bSourceIsCommandLine = true;
				Source = CommandLineFull;;
			}
			else if (variables.containsKey(SourceType))
			{
				Source = variables.get(SourceType);
			}
			else if (SourceType.equals("[EXIST]"))
			{
				Source = MatchString;
			}
			else
			{
				bConditionTrue = false;
				break;
			}

			// apply operation
			if (CompareType.equals("CMP_Exist"))
			{
				if (!variables.containsKey(Source))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_NotExist"))
			{
				if (variables.containsKey(Source))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_Equal"))
			{
				if (bSourceIsCommandLine)
				{
					if (!CommandLineFlags.containsKey(MatchString))
					{
						bConditionTrue = false;
						break;
					}
				}
				else if (!Source.equals(MatchString))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_NotEqual"))
			{
				if (bSourceIsCommandLine)
				{
					if (CommandLineFlags.containsKey(MatchString))
					{
						bConditionTrue = false;
						break;
					}
				}
				else if (Source.equals(MatchString))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_EqualIgnore"))
			{
				if (!Source.toLowerCase().equals(MatchString.toLowerCase()))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_NotEqualIgnore"))
			{
				if (Source.toLowerCase().equals(MatchString.toLowerCase()))
				{
					bConditionTrue = false;
					break;
				}
			}
			else if (CompareType.equals("CMP_Regex"))
			{
				Pattern pattern = Pattern.compile(MatchString);
				Matcher matcher = pattern.matcher(Source);
				if (matcher.find())
				{
					int groupCount = matcher.groupCount();
					PreviousRegexMatch = matcher.group(groupCount >= 1 ? 1 : 0);
				}
				else
				{
					bConditionTrue = false;
					break;
				}
			}
			else
			{
				boolean bNumericOperands = true;
				float SourceFloat = 0.0f;
				float MatchFloat = 0.0f;

				// convert source and match to float if numeric
				try
				{
					SourceFloat = Float.parseFloat(Source);
				}
				catch (NumberFormatException ne)
				{
					bNumericOperands = false;
				}
				try
				{
					MatchFloat = Float.parseFloat(MatchString);
				}
				catch (NumberFormatException ne)
				{
					bNumericOperands = false;
				}

				// if comparison ends with Ignore, do case-insensitive compare by converting both to lowercase
				if (CompareType.endsWith("Ignore"))
				{
					bNumericOperands = false;
					CompareType = CompareType.substring(0, CompareType.length() - 6);

					Source = Source.toLowerCase();
					MatchString = MatchString.toLowerCase();
				}

				if (CompareType.equals("CMP_Less"))
				{
					if ((bNumericOperands && (SourceFloat >= MatchFloat)) || (!bNumericOperands && (Source.compareTo(MatchString) >= 0)))
					{
						bConditionTrue = false;
						break;
					}
				}
				else if (CompareType.equals("CMP_LessEqual"))
				{
					if ((bNumericOperands && (SourceFloat > MatchFloat)) || (!bNumericOperands && (Source.compareTo(MatchString) > 0)))
					{
						bConditionTrue = false;
						break;
					}
				}
				else if (CompareType.equals("CMP_Greater"))
				{
					if ((bNumericOperands && (SourceFloat <= MatchFloat)) || (!bNumericOperands && (Source.compareTo(MatchString) <= 0)))
					{
						bConditionTrue = false;
						break;
					}
				}
				else if (CompareType.equals("CMP_GreaterEqual"))
				{
					if ((bNumericOperands && (SourceFloat < MatchFloat)) || (!bNumericOperands && (Source.compareTo(MatchString) < 0)))
					{
						bConditionTrue = false;
						break;
					}
				}
				else
				{
					bConditionTrue = false;
					break;
				}
			}
		}

		return bConditionTrue;
	}

	private boolean processSystemInfo(String ProjectName, String PackageName)
	{
		// check OpenGL information
		getGraphicsInformation();

		// get CPU / chipset information
		Map<String, String> cpuInfo = getCpuInfo();
		int processorCount = 1;
		if (cpuInfo.containsKey("processorCount"))
		{
			processorCount = Integer.parseInt(cpuInfo.get("processorCount"));
		}

		// check for libhoudini.so to identify Intel Atom
		File houdiniFile = new File("/system/lib/libhoudini.so");
		boolean bHasHoudini = houdiniFile.exists();

		// check for a processor id
		boolean bIsARM64 = false;
		boolean bHasNEON = false;
		String processor = "";
		if (cpuInfo.containsKey("Processor"))
		{
			processor = cpuInfo.get("Processor");
		}
		if (processor.contains("aarch64"))
		{
			bIsARM64 = true;
			bHasNEON = true;
		}

        String abilist = getProp("ro.product.cpu.abilist");
        if (abilist.contains("arm64-v8a"))
        {
            bIsARM64 = true;
        }

		// check each processor featureset
		for (int id=0; id < processorCount; id++)
		{
			String key = id + ":Features";
			if (cpuInfo.containsKey(key))
			{
				String features = cpuInfo.get(key);

				if (features.contains("neon"))
				{
					bHasNEON = true;
				}
				if (features.contains("asimd"))
				{
					// advanced SIMD is ARM64-v8a
					bHasNEON = true;
					bIsARM64 = true;
				}
			}
		}

		// try to get chip info
		// use getprop ro.hardware as fallback (not useful on Qualcomm, just returns qcom)
		String roHardware = getProp("ro.hardware");
		Log.debug("ro.hardware: " + roHardware);
		if (roHardware.equals("qcom"))
		{
			// use ro.hardware.chipname for Qualcomm
			String roHardwareChipname = getProp("ro.hardware.chipname");
			Log.debug("ro.hardware.chipname: " + roHardwareChipname);
			roHardware = roHardwareChipname;
		}
		String hardware = roHardware;
		if (cpuInfo.containsKey("Hardware"))
		{
			hardware = cpuInfo.get("Hardware");
		}
		Log.debug("Hardware: " + hardware);

		// register variables for the program to access
		Map<String, String> variables = new HashMap<String, String>();

		ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
		ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		activityManager.getMemoryInfo(memoryInfo);

		int totalMemory = (int)(memoryInfo.totalMem / 1024 / 1024);
		Log.debug("Memory: " + totalMemory + " MB");
		variables.put("memory", Integer.toString(totalMemory));

		//variables.put("Profile", "Android");
		variables.put("unsupportedDevice", "false");
		variables.put("OverrideProfile", "true");
		variables.put("hardware", hardware);
		variables.put("ro.hardware", roHardware);
		variables.put("processor", processor);
		variables.put("processorCount", Integer.toString(processorCount));
		variables.put("useAffinity", "false");
		variables.put("hasNEON", bHasNEON ? "true" : "false");
		variables.put("isARM64", bIsARM64 ? "true" : "false");
		variables.put("littleCoreMask", "0x0");
		variables.put("bigCoreMask", "0xffff");

		variables.put("SRC_GpuFamily", OpenGLDevice);
		variables.put("SRC_GlVersion", OpenGLDriver);
		variables.put("SRC_AndroidVersion", android.os.Build.VERSION.RELEASE);
		variables.put("SRC_DeviceMake", android.os.Build.MANUFACTURER);
		variables.put("SRC_DeviceModel", android.os.Build.MODEL);
		variables.put("SRC_DeviceBuildNumber", android.os.Build.DISPLAY);
		variables.put("SRC_VulkanVersion", VulkanVersionString);
		variables.put("SRC_VulkanAvailable", (bSupportsVulkan && VulkanVersionString != "0.0.0") ? "true" : "false");  // commandline could still disable!
		variables.put("SRC_UsingHoudini", bHasHoudini ? "true" : "false");

		variables.put("SRC_GpuVendor", OpenGLVendor);
		variables.put("SRC_SDKLevel", Integer.toString(android.os.Build.VERSION.SDK_INT));
		variables.put("supportsFloatingPointRenderTargets", bSupportsFloatingPointRenderTargets ? "true" : "false");
		variables.put("TextureFormats", TextureFormats);

		// get the status bar and navigation bar heights (only works for 5.0+)
		int statusBarHeight = 0;
		int navigationBarHeight = 0;
		if (Build.VERSION.SDK_INT >= 21)
		{
			android.content.res.Resources resources = getApplicationContext().getResources();
			int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
			if (resourceId > 0) {
				statusBarHeight += resources.getDimensionPixelSize(resourceId);
			}
			resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
			if (resourceId > 0) {
				navigationBarHeight += resources.getDimensionPixelSize(resourceId);
			}
		}
		variables.put("statusBarHeight", Integer.toString(statusBarHeight));
		variables.put("navigationBarHeight", Integer.toString(navigationBarHeight));

		// store the screen resolution (adjusted for immersive mode)
		android.view.Display display = getWindowManager().getDefaultDisplay();
		android.graphics.Point displaySize = new android.graphics.Point();
		if (ShouldHideUI)
		{
			display.getRealSize(displaySize);
		}
		else
		{
			display.getSize(displaySize);
		}
		variables.put("screenWidth", Integer.toString(displaySize.x));
		variables.put("screenHeight", Integer.toString(displaySize.y));

		// set early restart if -noearlyrestart not on commandline (configrules can clear this to disable or set to false)
		if (!CommandLineFlags.containsKey("noearlyrestart"))
		{
			variables.put("earlyrestart", "true");
		}

		String SaveError = "";
		String SaveWarning = "";

		// commandline flag may be used to skip dialog if not a shipping build
		boolean bIgnoreDialog = !nativeIsShippingBuild() && CommandLineFlags.containsKey("noconfigrulesdialog");


		
		// read the configuration file (configrules.bin.png)
		int configRulesVersion = 0;
		variables.put("configRulesVersion", Integer.toString(configRulesVersion));
		BufferedReader reader = null;
		InputStream stream = getConfigRulesStream(ProjectName);
		if (stream != null)
		{
			try
			{
				reader = new BufferedReader(new InputStreamReader(stream));
			}
			catch (Exception e)
			{
				ConfigRulesStatus += "failed to create config rules reader. " + e;
				reader = null;
			}
		}

		// process the rules
		if (reader != null)
		{
			// convert to lowercase once to check against chipset key
			String hardwareCheck = hardware.toLowerCase();
			
			try
			{
				Stack<Integer> StateStack = new Stack<Integer>();

				int currentState = CONFIGRULES_STATE_RUN;
				int nestDepth = 0;
				String line;
				while ((line = reader.readLine()) != null)
				{
					line = line.trim();
					if (line.length() < 1)
					{
						continue;
					}
					if (line.startsWith("//") || line.startsWith(";"))
					{
						if (line.startsWith("// version:"))
						{
							configRulesVersion = Integer.parseInt(line.substring(11));
							variables.put("configRulesVersion", Integer.toString(configRulesVersion));
							Log.debug("ConfigRules version: " + configRulesVersion);
						}
						continue;
					}

					// look for command
					int index = line.indexOf(":");
					if (index == -1)
					{
						continue;
					}
					String command = line.substring(0, index).trim();
					line = line.substring(index + 1).trim();

					// handle states
					switch (currentState)
					{
						case CONFIGRULES_STATE_RUN:
							if (command.equals("else") || command.equals("elseif") || command.equals("endif"))
							{
								Log.debug("ConfigRules: unexpected " + command + " encountered!");
							}
							break;

						case CONFIGRULES_STATE_EXECTRUE:
							if (command.equals("else"))
							{
								currentState = CONFIGRULES_STATE_FINDEND;
								continue;
							}
							if (command.equals("endif"))
							{
								currentState = StateStack.pop();
								continue;
							}
							break;

						case CONFIGRULES_STATE_FINDELSE:
							if (command.equals("if"))
							{
								nestDepth++;
								continue;
							}
							if (nestDepth > 0)
							{
								if (command.equals("endif"))
								{
									nestDepth--;
								}
								continue;
							}
							if (command.equals("endif"))
							{
								currentState = StateStack.pop();
								continue;
							}
							if (command.equals("else"))
							{
								currentState = CONFIGRULES_STATE_EXECFALSE;
								continue;
							}
							if (command.equals("elseif"))
							{
								currentState = CONFIGRULES_STATE_FINDEND;

								ArrayList<String> conditions = ParseSegments(line, ",", "(\"", ")\"");
								int setsize = conditions.size();
								if (setsize > 0)
								{
									boolean bConditionTrue = EvaluateConditions(variables, conditions, "");
									currentState = bConditionTrue ? CONFIGRULES_STATE_EXECTRUE : CONFIGRULES_STATE_FINDELSE;
								}
							}
							continue;

						case CONFIGRULES_STATE_EXECFALSE:
							if (command.equals("endif"))
							{
								currentState = StateStack.pop();
								continue;
							}
							if (command.equals("else") || command.equals("elseif"))
							{
								Log.debug("ConfigRules: unexpected " + command + " while handling false condition!");
								continue;
							}
							break;

						case CONFIGRULES_STATE_FINDEND:
							if (command.equals("if"))
							{
								nestDepth++;
								continue;
							}
							if (nestDepth > 0)
							{
								if (command.equals("endif"))
								{
									nestDepth--;
								}
								continue;
							}
							if (command.equals("endif"))
							{
								currentState = StateStack.pop();
							}
							continue;

						default:
							Log.debug("ConfigRules: unknown state!");
							continue;
					}

					// handle commands
					if (command.equals("set"))
					{
						// set:(a=b[,c=d,...])
						ArrayList<String> sets = ParseSegments(RemoveSurrounds(line, "(", ")"), ",", "(\"", ")\"");
						for (String assignment : sets)
						{
							ArrayList<String> keyvalue = ParseSegments(assignment, "=", "\"", "\"");
							if (keyvalue.size() == 2)
							{
								String key = RemoveSurrounds(keyvalue.get(0), "\"", "\"");
								String value = ExpandVariables(variables, RemoveSurrounds(keyvalue.get(1), "\"", "\""));
								if (key.startsWith("APPEND_"))
								{
									key = key.substring(7);
									if (variables.containsKey(key))
									{
										value = variables.get(key) + value;
									}
									variables.put(key, value);
								}
								else
								{
									variables.put(key, value);
								}
							}
						}
					}
					else if (command.equals("clear"))
					{
						// clear:(a[,b,...])
						ArrayList<String> sets = ParseSegments(RemoveSurrounds(line, "(", ")"), ",", "(\"", ")\"");
						for (String key : sets)
						{
							variables.remove(RemoveSurrounds(key, "\"", "\""));
						}
					}
					else if (command.equals("chipset"))
					{
						// chipset:"hardware",useAffinity,"chipset","cpu",processorCount,bigCoreMask,littleCoreMask

						// only check if haven't already set chipset
						if (!variables.containsKey("chipset"))
						{
							ArrayList<String> values = ParseSegments(line, ",", "\"", "\"");
							if (values.size() == 7)
							{
								String key = RemoveSurrounds(values.get(0), "\"", "\"").toLowerCase();
								if (key.contains(hardwareCheck) || hardwareCheck.contains(key))
								{
									variables.put("useAffinity", RemoveSurrounds(values.get(1), "\"", "\""));
									variables.put("chipset", RemoveSurrounds(values.get(2), "\"", "\""));
									variables.put("gpu", RemoveSurrounds(values.get(3), "\"", "\""));
									variables.put("processorCount", RemoveSurrounds(values.get(4), "\"", "\""));
									variables.put("bigCoreMask", RemoveSurrounds(values.get(5), "\"", "\""));
									variables.put("littleCoreMask", RemoveSurrounds(values.get(6), "\"", "\""));

									Log.debug("Chipset: " + variables.get("chipset"));
									Log.debug("GPU: " + variables.get("gpu"));
								}
							}
						}
					}
					else if (command.equals("if"))
					{
						// if:(SourceType=SRC_DeviceMake,CompareType=CMP_Equal,MatchString="samsung")
						// ... commands for true for all conditions
						// elseif:(SourceType=SRC_DeviceMake,CompareType=CMP_Equal,MatchString="Google")
						// ... commands for true for all conditions
						// else:
						// ... commands for false for any condition
						// end:
						StateStack.push(currentState);
						currentState = CONFIGRULES_STATE_FINDEND;

						ArrayList<String> conditions = ParseSegments(line, ",", "(\"", ")\"");
						int setsize = conditions.size();
						if (setsize > 0)
						{
							boolean bConditionTrue = EvaluateConditions(variables, conditions, "");
							currentState = bConditionTrue ? CONFIGRULES_STATE_EXECTRUE : CONFIGRULES_STATE_FINDELSE;
						}
					}
					else if (command.equals("condition"))
					{
						// condition:((SourceType=SRC_DeviceMake,CompareType=CMP_Equal,MatchString="samsung")),(SourceType=,CompareType=,MatchString=),...]),(a=b[,c=d,...]),(a[,b,...])
						// if all the conditions are true, execute the optional sets and/or clears
						ArrayList<String> conditionAndSets = ParseSegments(line, ",", "(\"", ")\"");
						int setsize = conditionAndSets.size();
						if (setsize == 2 || setsize == 3)
						{
							ArrayList<String> conditions = ParseSegments(RemoveSurrounds(conditionAndSets.get(0), "(", ")"), ",", "(\"", ")\"");
							ArrayList<String> sets = ParseSegments(RemoveSurrounds(conditionAndSets.get(1), "(", ")"), ",", "(\"", ")\"");
							ArrayList<String> clears = (setsize == 3) ? ParseSegments(RemoveSurrounds(conditionAndSets.get(2), "(", ")"), ",", "(\"", ")\"") : new ArrayList<String>();

							boolean bConditionTrue = EvaluateConditions(variables, conditions, "");

							if (bConditionTrue)
							{
								// run the sets
								for (String assignment : sets)
								{
									ArrayList<String> keyvalue = ParseSegments(assignment, "=", "\"", "\"");
									if (keyvalue.size() == 2)
									{
										String key = RemoveSurrounds(keyvalue.get(0), "\"", "\"");
										String value = ExpandVariables(variables, RemoveSurrounds(keyvalue.get(1), "\"", "\""));
										if (key.startsWith("APPEND_"))
										{
											key = key.substring(7);
											if (variables.containsKey(key))
											{
												value = variables.get(key) + value;
											}
											variables.put(key, value);
										}
										else
										{
											variables.put(key, value);
										}
									}
								}

								// run the clears
								for (String key : clears)
								{
									variables.remove(RemoveSurrounds(key, "\"", "\""));
								}
							}
						}
					}

					// see if log message requested
					if (variables.containsKey("log"))
					{
						Log.debug(variables.get("log"));
						variables.remove("log");
					}

					// check if requested to dump cpu info to the log
					if (variables.containsKey("dumpcpuinfo"))
					{
						variables.remove("dumpcpuinfo");
						Log.debug("cpuInfo:");
						for (Map.Entry<String, String> entry : cpuInfo.entrySet())
						{
							Log.debug("  " + entry.getKey() + " = " + entry.getValue());
						}
					}

					// check if requested to dump variables to the log
					if (variables.containsKey("dumpvars"))
					{
						variables.remove("dumpvars");
						Log.debug("variables:");
						for (Map.Entry<String, String> entry : variables.entrySet())
						{
							Log.debug("  " + entry.getKey() + " = " + entry.getValue());
						}
					}

					// if there was a raised error, stop
					boolean hasError = variables.containsKey("error");
					boolean hasWarning = variables.containsKey("warning");
					if (hasError || hasWarning)
					{
						ForceExitLink = "";
						if (variables.containsKey("link"))
						{
							ForceExitLink = variables.get("link");
						}

						ForceExitUpdateButtonText = "";
						if (variables.containsKey("updatebutton"))
						{
							ForceExitUpdateButtonText = getResourceStringOrDefault(PackageName, variables.get("updatebutton"), ForceExitUpdateButtonText);
						}

						ForceExitHelpButtonText = "Help";
						if (variables.containsKey("helpbutton"))
						{
							ForceExitHelpButtonText = getResourceStringOrDefault(PackageName, variables.get("helpbutton"), ForceExitHelpButtonText);
						}

						ForceExitQuitButtonText = "Quit";
						if (variables.containsKey("exitbutton"))
						{
							ForceExitQuitButtonText = getResourceStringOrDefault(PackageName, variables.get("exitbutton"), ForceExitQuitButtonText);
						}

						ForceExitContinueButtonText = "Continue";
						if (variables.containsKey("continuebutton"))
						{
							ForceExitContinueButtonText = getResourceStringOrDefault(PackageName, variables.get("continuebutton"), ForceExitContinueButtonText);
						}

						// localize caption string from string table
						ForceExitCaption = "Device not supported";
						if (variables.containsKey("caption"))
						{
							ForceExitCaption = getResourceStringOrDefault(PackageName, variables.get("caption"), ForceExitCaption);
						}

						// check if ignoring the warnings and errors
						if (bIgnoreDialog)
						{
							if (hasWarning)
							{
								hasWarning = false;
								variables.remove("warning");
							}
							if (hasError)
							{
								hasError = false;
								variables.remove("error");
							}
						}

						if (hasWarning)
						{
							SaveWarning = variables.get("warning");

							// localize error string from string table
							ForceExitMessage = getResourceStringOrDefault(PackageName, SaveWarning, "This device may not run this game.");
							variables.remove("warning");
							bForceGameEndWithWarning = true;
						}

						if (hasError)
						{
							SaveError = variables.get("error");

							// localize error string from string table
							ForceExitMessage = getResourceStringOrDefault(PackageName, SaveError, "This device cannot run this game.");
							bForceGameEndWithError = true;
							break;
						}
					}

					// stop if user wants to break
					if (variables.containsKey("break"))
					{
						break;
					}
				}
			}
			catch (IOException ie)
			{
				Log.debug("failed to read configuration rules: " + ie);
				ConfigRulesStatus += "failed to read configuration rules : " + ie+ " ";
			}
			if (reader != null)
			{
				ConfigRulesStatus += "configuration rules finished. " + ForceExitMessage;
				try
				{
					reader.close();
				}
				catch (IOException ie)
				{
				}
			}
		}
		else if (bConfigRulesError)
		{
			// there was an issue with the configrules so can't continue
			ForceExitCaption = getResourceStringOrDefault(PackageName, "CR_Caption_DeviceNotSupported", "Device Not Supported");
			ForceExitQuitButtonText = getResourceStringOrDefault(PackageName, "CR_Button_Quit", "Quit");
			ForceExitMessage = getResourceStringOrDefault(PackageName, "CR_Info_DeviceNotSupportedYet", "This device is in supported yet.");
			SaveError = "ConfigRules_Problem";
			bForceGameEndWithError = true;
		}
		if (stream != null)
		{
			try
			{
				stream.close();
			}
			catch (Exception e)
			{
			}
		}

		// clear Profile if OverrideProfile was not left set as well
		if (variables.containsKey("Profile"))
		{
			if (!variables.containsKey("OverrideProfile"))
			{
				variables.remove("Profile");
			}
		}

		// notify AndroidProcess of the core masks and affinity enable state
		if (variables.containsKey("unsupportedDevice"))
		{
			bSupportedDevice = variables.get("unsupportedDevice").equals("false");
		}
		boolean bUseAffinity = variables.get("useAffinity").equals("true");
		int littleCoreMask = Integer.decode(variables.get("littleCoreMask"));
		int bigCoreMask = Integer.decode(variables.get("bigCoreMask"));
		Log.debug("UseAffinity: " + (bUseAffinity ? "true" : "false"));
		Log.debug("BigCoreMask: 0x" + Integer.toHexString(bigCoreMask));
		Log.debug("LittleCoreMask: 0x" + Integer.toHexString(littleCoreMask));
		nativeSetAffinityInfo(bUseAffinity, bigCoreMask, littleCoreMask);

		// send the variables to the engine
		String[] keyValues = new String[variables.size() * 2];
		int keyValueIndex = 0;
		for (Map.Entry<String, String> entry : variables.entrySet())
		{
			keyValues[keyValueIndex++] = entry.getKey();
			keyValues[keyValueIndex++] = entry.getValue();
		}
		nativeSetConfigRulesVariables(keyValues);




		return !bForceGameEndWithError;
	}

	public void LoggerCallback(String Level, String Tag, String Message)
	{

	}

	protected View GetMainView()
	{
		return mainView;
	}

	protected Rect GetSafezone()
	{
		return safezone;
	}

	protected FrameLayout GetContainerFrameLayout()
	{
		return containerFrameLayout;
	}

	protected String FindLineFromStatus(String fieldToReport)
	{
		File file = new File("/proc/self/status");
		if (file.exists())
		{
			try (BufferedReader reader = new BufferedReader(new FileReader(file));)
			{
				String line;
				while ((line = reader.readLine()) != null)
				{
					if(line.contains(fieldToReport))
					{
						return line;
					}
				}
			}
			 catch (IOException ie)
			 {
				Log.debug("failed to read status: " + ie);
			}
		}
		return "";
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Logger.RegisterCallback(this);

		// Grab a reference to the asset manager
		AssetManagerReference = this.getAssets();

		_activity = this;
		super.onCreate(savedInstanceState);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

		InternalFilesDir = getFilesDir().getAbsolutePath() + "/";
		ExternalFilesDir = getExternalFilesDir(null).getAbsolutePath() + "/";

		// disable autofill to avoid possible Android 10 crash (android.view.autofill.AutofillManager.ensureServiceClientAddedIfNeededLocked() SyncResultReceiver$TimeoutException)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
		{
			getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
		}

		// create splashscreen dialog (if launched by SplashActivity)
		_extrasBundle = getIntent().getExtras();
		if (_extrasBundle != null)
		{
			ShouldHideUI = _extrasBundle.getString("ShouldHideUI") != null;
			UseDisplayCutout = _extrasBundle.getString("UseDisplayCutout") != null;
			if (_extrasBundle.getString("UseSplashScreen") != null)
			{
				SplashScreenLaunch = true;
				try {
					// try to get the splash theme (can't use R.style.UE4SplashTheme since we don't know the package name until runtime)
					int SplashThemeId = getResources().getIdentifier("UE4SplashTheme", "style", getPackageName());
					mSplashDialog = new Dialog(this, SplashThemeId);
					mSplashDialog.setCancelable(false);

					// Setting NOT_FOCUSABLE prevents the splash dialog from kicking some devices out of immersive mode.
					mSplashDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
					
					if (ShouldHideUI)
					{
						View decorView = mSplashDialog.getWindow().getDecorView(); 
						// only do this on KitKat and above
						if(android.os.Build.VERSION.SDK_INT >= 19) {
							decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
														| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
														| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
														| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
														| View.SYSTEM_UI_FLAG_FULLSCREEN
														| View.SYSTEM_UI_FLAG_IMMERSIVE);  // NOT sticky.. will be set to sticky later! 
						}
					}
					mSplashDialog.show();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				try {
					noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			if (UseDisplayCutout)
			{
				// will not be true if not Android Pie or later
	            WindowManager.LayoutParams params = getWindow().getAttributes();
		        params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
			    getWindow().setAttributes(params);
			}
		}

		//Check for target sdk.  If 23 or higher then warn that permission handling may mean features don't work if user denies them.
		int targetSdkVersion = 0;
		try 
		{
			PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
			targetSdkVersion = packageInfo.applicationInfo.targetSdkVersion;
		}
		catch (PackageManager.NameNotFoundException e) 
		{
			Log.debug(e.getMessage());
		}

		boolean bIsShipping = nativeIsShippingBuild();
		if (ANDROID_BUILD_VERSION >= 23 && targetSdkVersion >= 23) //23 is the API level (Marshmallow) where runtime permission handling is available
		{
			Log.debug("Target SDK is " + targetSdkVersion + ".  This may cause issues if permissions are denied by the user." );	
			if (!bIsShipping)
			{
				// For non-shipping builds we may need this permission because we write to the sdcard for logs
				if (!PermissionHelper.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
				{
					Log.debug("android.permission.WRITE_EXTERNAL_STORAGE was not granted; this may cause issues with file access." );
					// we do not do this currently since we must wait until it is granted before accessing files
					// SplashActivity takes care of properly gating this in the cases it is needed
					//PermissionHelper.acquirePermissions(new String[] {"android.permission.WRITE_EXTERNAL_STORAGE"}, this);
				}
			}
		}
		
		// Suppress java logs in Shipping builds
		if (bIsShipping)
		{
			Logger.SuppressLogs();
		}
		
		MemAdvisor = new MemoryAdvisor(this);
		LastMemoryInfoPollTime = System.currentTimeMillis();

		// update memory stats every 10 seconds
		memoryRunnable = new Runnable() {
			@Override
			public void run()
			{
				JSONObject Advice = MemAdvisor.getAdvice();
				MemoryAdvisor.MemoryState CurrentMemoryState = MemoryAdvisor.getMemoryState(Advice);
				final int MB = 1024 * 1024;
				int AvailableEstimateMB = (int)(MemoryAdvisor.availabilityEstimate(Advice) / MB);
				int OOMScore = Advice.optJSONObject("metrics").optJSONObject("proc").optInt("oom_score", -1);

				long CurrentTimeMs = System.currentTimeMillis();
				boolean StateChanged = CurrentMemoryState != MemState;
				boolean NewStateIsHigher = CurrentMemoryState.ordinal() > MemState.ordinal();
				boolean StateDecreaseTimePassed = CurrentTimeMs - LastMemAdvisorStateUpdateTime >= MemoryAdvisorStateDecreaseDelayMs;
				// Prevent reporting state change every time when state is oscillating between two states with high frequency
				if (StateChanged && (NewStateIsHigher || StateDecreaseTimePassed))
				{
					switch (CurrentMemoryState)
					{
						case OK:
							Log.debug("[MemoryAdvisor] Significant amount of memory is available for allocation. Estimate is " + AvailableEstimateMB + " MB");
							break;
						case APPROACHING_LIMIT:
							Log.warn("[MemoryAdvisor] Approaching memory limit. Estimated available memory is " + AvailableEstimateMB + " MB");
							break;
						case CRITICAL:
							Log.warn("[MemoryAdvisor] Critical memory limit. Estimated available memory is " + AvailableEstimateMB + " MB");
							break;
						case UNKNOWN:
						default:
							Log.error("[MemoryAdvisor] Unexpected memory state: " + CurrentMemoryState);
							break;
					}
					
					MemState = CurrentMemoryState;
					LastMemAdvisorStateUpdateTime = CurrentTimeMs;	
				}
				
				nativeSetMemoryAdvisorState(CurrentMemoryState.ordinal() - 1, AvailableEstimateMB, OOMScore);

				
				int ProcessMemory = 0;
				if (CurrentTimeMs - LastMemoryInfoPollTime >= ProcessMemoryInfoPollDelayMs)
				{
					ActivityManager activityManager = (ActivityManager)_activity.getSystemService(Context.ACTIVITY_SERVICE);
					int pid = android.os.Process.myPid();
					int pids[] = new int[] { pid };
					android.os.Debug.MemoryInfo[] memoryInfo = activityManager.getProcessMemoryInfo(pids);
					if (memoryInfo.length > 0)
					{
						ProcessMemory = memoryInfo[0].dalvikPss + memoryInfo[0].nativePss + memoryInfo[0].otherPss;

						if (Build.VERSION.SDK_INT >= 23)
						{
							Map<String, String> memstats = memoryInfo[0].getMemoryStats();
							if (memstats.containsKey("summary.total-pss"))
							{
								ProcessMemory = Integer.parseInt(memstats.get("summary.total-pss"));
							}
						}
					}
					Log.debug("Used memory: " + ProcessMemory + " ("+FindLineFromStatus("VmRSS:")+")");
					LastMemoryInfoPollTime = CurrentTimeMs;
				}
				
				synchronized(_activity)
				{
					if (ProcessMemory > 0)
					{
						_activity.UsedMemory = ProcessMemory;
					}
					
					if (_activity.memoryHandler != null)
					{
						_activity.memoryHandler.postDelayed(this, _activity.MemoryAdvisorPollDelayMs);
					}
				}
			}
		};
		memoryHandlerThread = new HandlerThread("MemoryUsageThread", android.os.Process.THREAD_PRIORITY_LOWEST);
		memoryHandlerThread.start();
		memoryHandler = new Handler(memoryHandlerThread.getLooper());
		memoryHandler.postDelayed(memoryRunnable, 1);

		// layout required by popups, e.g ads, native controls
		MarginLayoutParams params = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 0, 0, 0);
		activityLayout = new LinearLayout(_activity);
		_activity.setContentView(activityLayout, params);

/*
		// Turn on and unlock screen.. Assumption is that this
		// will only really have an effect when for debug launching
		// as otherwise the screen is already unlocked.
		this.getWindow().addFlags(
			WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
//			WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
			WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		// On some devices we can also unlock a key-locked screen by disabling the
		// keylock guard. To be safe we only do this on < Android 3.2. As the API
		// is deprecated from 3.2 onward.
		if (ANDROID_BUILD_VERSION < 13)
		{
			android.app.KeyguardManager keyman = (android.app.KeyguardManager)getSystemService(KEYGUARD_SERVICE);
			android.app.KeyguardManager.KeyguardLock keylock = keyman.newKeyguardLock("Unlock");
			keylock.disableKeyguard();
		}
*/

/*
		// log a list of input devices for debugging
		{
			int[] deviceIds = InputDevice.getDeviceIds();
			for (int deviceIndex=0; deviceIndex < deviceIds.length; deviceIndex++)
			{
				InputDevice inputDevice = InputDevice.getDevice(deviceIds[deviceIndex]);
				Log.debug("Device index " + deviceIndex + ": (deviceId=" + inputDevice.getId() + 
				", controllerNumber=" + inputDevice.getControllerNumber() + ", sources=" + String.format("%08x", inputDevice.getSources()) +
				", vendorId=" + String.format("%04x", inputDevice.getVendorId()) + ", productId=" + String.format("%04x", inputDevice.getProductId()) + 
				", descriptor=" + inputDevice.getDescriptor() +	", deviceName=" + inputDevice.getName() + ")");

				// is it a joystick?
				if ((inputDevice.getSources() & InputDevice.SOURCE_JOYSTICK) != 0)
				{
					Log.debug("Gamepad detected: (deviceIndex=" + deviceIndex + ", deviceId=" + inputDevice.getId() + ", deviceName=" + inputDevice.getName() + ")");
				}
			}
		}
*/

		// tell Android that we want volume controls to change the media volume, aka music
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		// Look for Vulkan support if Nougat or later
		if (ANDROID_BUILD_VERSION >= 24)
		{
			FeatureInfo[] features = getPackageManager().getSystemAvailableFeatures();
			for (FeatureInfo feature : features) {
				if (feature.name != null)
				{
					if (feature.name.equals("android.hardware.vulkan.level"))
					{
						// since we may not be compiled against android-24 or higher, use .toString to get the version field
						String dump = feature.toString();
						int index = dump.indexOf("v=");
						if (index >= 0)
						{
							dump = dump.substring(index+2);
							index = dump.indexOf(" ");
							if (index >= 0)
							{
								VulkanLevel = Integer.parseInt(dump.substring(0, index));
								Log.debug("Vulkan level: " + VulkanLevel);
							}
						}
					}
					else
					if (feature.name.equals("android.hardware.vulkan.version"))
					{
						// since we may not be compiled against android-24 or higher, use .toString to get the version field
						String dump = feature.toString();
						int index = dump.indexOf("v=");
						if (index >= 0)
						{
							dump = dump.substring(index+2);
							index = dump.indexOf(" ");
							if (index >= 0)
							{
								VulkanVersion = Integer.parseInt(dump.substring(0, index));
								int VersionMajor = (VulkanVersion >> 22) & 0x03ff;
								int VersionMinor = (VulkanVersion >> 12) & 0x03ff;
								int VersionPatch = VulkanVersion & 0x0fff;
								VulkanVersionString = VersionMajor + "." + VersionMinor + "." + VersionPatch;
								Log.debug("Vulkan version: " + VersionMajor + "." + VersionMinor + "." + VersionPatch);
							}
						}
					}
				}
			}
		}

		// is this a native landscape device (tablet, tv)?
		if ( getDeviceDefaultOrientation() == Configuration.ORIENTATION_LANDSCAPE )
		{
			boolean bForceLandscape = false;

			// check for a Google TV by checking system feature support
			if (getPackageManager().hasSystemFeature("com.google.android.tv"))
			{
				Log.debug( "Detected Google TV, will default to landscape" );
				bForceLandscape = true;
			} else

			// check NVidia devices
			if (android.os.Build.MANUFACTURER.equals("NVIDIA"))
			{
				// is it a Shield? (checking exact model)
				if (android.os.Build.MODEL.equals("SHIELD"))
				{
					Log.debug( "Detected NVidia Shield, will default to landscape" );
					bForceLandscape = true;
				}
			} else

			// check Ouya
			if (android.os.Build.MANUFACTURER.equals("OUYA"))
			{
				// only one so far (ouya_1_1) but check prefix anyway
				if (android.os.Build.MODEL.toLowerCase().startsWith("ouya_"))
				{
					Log.debug( "Detected Ouya console (" + android.os.Build.MODEL + "), will default to landscape" );
					bForceLandscape = true;
				}
			} else

			// check Amazon devices
			if (android.os.Build.MANUFACTURER.equals("Amazon"))
			{
				// is it a Kindle Fire TV? (Fire TV FAQ says AFTB, but to check for AFT)
				if (android.os.Build.MODEL.startsWith("AFT"))
				{
					Log.debug( "Detected Kindle Fire TV (" + android.os.Build.MODEL + "), will default to landscape" );
					bForceLandscape = true;
				}
			}

			// apply the force request if we found a device above
			if (bForceLandscape)
			{
				Log.debug( "Setting screen orientation to landscape because we have detected landscape device" );
				_activity.setRequestedOrientation( android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
			}
		}
		
		// Read metadata from AndroidManifest.xml
		appPackageName = getPackageName();
		String ProjectName = getPackageName();
		ProjectName = ProjectName.substring(ProjectName.lastIndexOf('.') + 1);
		String AppType = "";
		try {
			ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			Bundle bundle = ai.metaData;
			_bundle = bundle;

			if ((ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) == 0) 
			{
				IsForDistribution = true;
			}

			// Get the preferred depth buffer size from AndroidManifest.xml
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.DepthBufferPreference"))
			{
				DepthBufferPreference = bundle.getInt("com.epicgames.ue4.GameActivity.DepthBufferPreference");
				Log.debug( "Found DepthBufferPreference = " + DepthBufferPreference);
			}
			else
			{
				Log.debug( "Did not find DepthBufferPreference, using default.");
			}

			// Determine if data is embedded in APK from AndroidManifest.xml
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.bPackageDataInsideApk"))
			{
				PackageDataInsideApkValue = bundle.getBoolean("com.epicgames.ue4.GameActivity.bPackageDataInsideApk") ? 1 : 0;
				Log.debug( "Found bPackageDataInsideApk = " + PackageDataInsideApkValue);
			}
			else
			{
				PackageDataInsideApkValue = 0;
				Log.debug( "Did not find bPackageDataInsideApk, using default.");
			}

			// Get the project name from AndroidManifest.xml
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.ProjectName"))
			{
				ProjectName = bundle.getString("com.epicgames.ue4.GameActivity.ProjectName");
				Log.debug( "Found ProjectName = " + ProjectName);
			}
			else
			{
				Log.debug( "Did not find ProjectName, using package name = " + ProjectName);
			}
			
			// Get the application type from AndroidManifest.xml
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.AppType"))
			{
				AppType = bundle.getString("com.epicgames.ue4.GameActivity.AppType");
				Log.debug( "Found AppType = " + AppType);
			}
			else
			{
				Log.debug( "Did not find AppType, using default application type");
			}
			
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.bHasOBBFiles"))
			{
				HasOBBFiles = bundle.getBoolean("com.epicgames.ue4.GameActivity.bHasOBBFiles") ? 1 : 0;
				Log.debug( "Found bHasOBBFiles = " + HasOBBFiles);
			}
			else
			{
				HasOBBFiles = 0;
				Log.debug( "Did not find bHasOBBFiles, using default.");
			}
			
			if (bundle.containsKey("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp"))
			{
				VerifyOBBOnStartUp = bundle.getBoolean("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp");
				Log.debug( "Found bVerifyOBBOnStartUp = " + VerifyOBBOnStartUp);
			}
			else
			{
				VerifyOBBOnStartUp = false;
				Log.debug( "Did not find bVerifyOBBOnStartUp, using default.");
			}

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.bShouldHideUI"))
			{
				ShouldHideUI = bundle.getBoolean("com.epicgames.ue4.GameActivity.bShouldHideUI");
				Log.debug( "UI hiding set to " + ShouldHideUI);
			}
			else
			{
				Log.debug( "UI hiding not found. Leaving as " + ShouldHideUI);
			}

			if (SplashScreenLaunch == false && android.os.Build.VERSION.SDK_INT >= 28)
			{
				if(bundle.containsKey("com.epicgames.ue4.GameActivity.bUseDisplayCutout"))
				{
					UseDisplayCutout = bundle.getBoolean("com.epicgames.ue4.GameActivity.bUseDisplayCutout");
					Log.debug( "Display cutout set to " + UseDisplayCutout);
				}
				else
				{
					Log.debug( "Display cutout not found. Leaving as " + UseDisplayCutout);
				}
			}

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.BuildConfiguration"))
			{
				BuildConfiguration = bundle.getString("com.epicgames.ue4.GameActivity.BuildConfiguration");
				Log.debug( "BuildConfiguration set to " + BuildConfiguration);
			}
			else
			{
				Log.debug( "BuildConfiguration not found" );
			}

			if (bundle.containsKey("com.epicgames.ue4.GameActivity.bUseExternalFilesDir"))
            {
                UseExternalFilesDir = bundle.getBoolean("com.epicgames.ue4.GameActivity.bUseExternalFilesDir");
                Log.debug( "UseExternalFilesDir set to " + UseExternalFilesDir);
            }
            else
            {
                Log.debug( "bUseExternalFilesDir not found. Leaving as " + UseExternalFilesDir);
            }

			if (bundle.containsKey("com.epicgames.ue4.GameActivity.bPublicLogFiles"))
            {
                PublicLogFiles = bundle.getBoolean("com.epicgames.ue4.GameActivity.bPublicLogFiles");
                Log.debug( "PublicLogFiles set to " + PublicLogFiles);
            }
            else
            {
                Log.debug( "PublicLogFiles not found. Leaving as " + PublicLogFiles);
            }

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.bAllowIMU"))
			{
				bAllowIMU = bundle.getBoolean("com.epicgames.ue4.GameActivity.bAllowIMU");
				Log.debug( "AllowIMU set to " + bAllowIMU);
			}

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.bSupportsVulkan"))
			{
				bSupportsVulkan = bundle.getBoolean("com.epicgames.ue4.GameActivity.bSupportsVulkan");
				Log.debug( "SupportsVulkan set to " + bSupportsVulkan);
			}

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.EngineBranch"))
			{
				EngineBranch = bundle.getString("com.epicgames.ue4.GameActivity.EngineBranch");
			}

			if(bundle.containsKey("com.epicgames.ue4.GameActivity.ProjectVersion"))
			{
				ProjectVersion = bundle.getString("com.epicgames.ue4.GameActivity.ProjectVersion");
			}

					boolean hasVR = false;

					Intent vrIntent = new Intent(Intent.ACTION_MAIN, null);
					vrIntent.addCategory("com.oculus.intent.category.VR");
					vrIntent.addFlags(PackageManager.GET_INTENT_FILTERS);
					vrIntent.setPackage(getApplicationContext().getPackageName());

					PackageManager pkgManager = getApplicationContext().getPackageManager();
					if (pkgManager != null)
					{
						if(!pkgManager.queryIntentActivities(vrIntent, PackageManager.GET_INTENT_FILTERS).isEmpty())
						{
							hasVR = true;
						}
					}

					if (bundle.containsKey("com.samsung.android.vr.application.mode"))
					{
						hasVR = true;
					}

					if (hasVR)
					{
						PackagedForOculusMobile = true;
						bUsesVrKeyboard = true;
						Log.debug("Found Oculus Mobile mode.");
					}
					else
					{
						PackagedForOculusMobile = false;
						Log.debug("No Oculus Mobile mode detected.");
					}

		}
		catch (NameNotFoundException e)
		{
			Log.debug( "Failed to load meta-data: NameNotFound: " + e.getMessage());
		}
		catch (NullPointerException e)
		{
			Log.debug( "Failed to load meta-data: NullPointer: " + e.getMessage());
		}

		// parse the commandline
		ParseCommandline(ProjectName, UseExternalFilesDir);



		// run configuration rules
		if (!processSystemInfo(ProjectName, appPackageName))
		{
			// configuration failed (show error)
			return;
		}

		String APKPath = getPackageResourcePath();

		Log.debug("APK path: " + APKPath);
		Log.debug("OBB in APK: " + (PackageDataInsideApkValue==1));
		nativeSetGlobalActivity(UseExternalFilesDir, PublicLogFiles, getFilesDir().getPath(), getExternalFilesDir(null).getPath(), PackageDataInsideApkValue==1, APKPath);

		// tell the engine if this is a portrait app
		nativeSetWindowInfo(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT, DepthBufferPreference);

		// get the full language code, like en-US
		// note: this may need to be Locale.getDefault().getLanguage()
		String Language = java.util.Locale.getDefault().toString();

		boolean bDebuggerAttached = android.os.Debug.isDebuggerConnected();
		nativeSetAndroidStartupState(bDebuggerAttached);

		Log.debug( "Android version is " + android.os.Build.VERSION.RELEASE );
		Log.debug( "Android manufacturer is " + android.os.Build.MANUFACTURER );
		Log.debug( "Android model is " + android.os.Build.MODEL );
		Log.debug( "Android build number is " + android.os.Build.DISPLAY );
		Log.debug( "OS language is set to " + Language );
		Log.debug( "Debugger attached is " + bDebuggerAttached );

		nativeSetAndroidVersionInformation( android.os.Build.VERSION.RELEASE, targetSdkVersion, android.os.Build.MANUFACTURER, android.os.Build.MODEL, android.os.Build.DISPLAY, Language );

		try
		{
			VersionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
			int PatchVersion = 0;
			nativeSetObbInfo(ProjectName, getApplicationContext().getPackageName(), VersionCode, PatchVersion, AppType);
		}
		catch (Exception e)
		{
			// if the above failed, then, we can't use obbs
			Log.debug("==================================> PackageInfo failure getting .obb info: " + e.getMessage());
		}
		
		// enable the physical volume controls to the game
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

		AlertDialog.Builder builder;

		consoleInputBox = new ConsoleKeyboardInput(this);
		consoleInputBox.setInputType(0x00080001); // TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_NO_SUGGESTIONS);
		
		RelativeLayout consoleInputLayout = new RelativeLayout(this);
		{ 
			android.widget.ImageButton consoleHistoryButton = consoleInputBox.getButton();
			consoleInputBox.setId(1);
			consoleHistoryButton.setId(2);
			
			RelativeLayout.LayoutParams lpCIB = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lpCIB.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			lpCIB.addRule(RelativeLayout.LEFT_OF, 2);
			
			RelativeLayout.LayoutParams lpCHB = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			lpCHB.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			
			consoleInputLayout.addView(consoleInputBox, lpCIB);
			consoleInputLayout.addView(consoleHistoryButton, lpCHB);
		}

		// Spinner with Quick Stat Commands
		consoleSpinner = new Spinner(this);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CONSOLE_SPINNER_ITEMS);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		consoleSpinner.setAdapter(adapter);
		consoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
				if (pos > 0)
					consoleInputBox.setText(adapterView.getItemAtPosition(pos).toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
				consoleInputBox.setText("");
				consoleSpinner.setSelection(0);
			}
		});

		// Layout for Quick Commands and Console Input
		consoleAlertLayout = new LinearLayout(this);
		consoleAlertLayout.setOrientation(LinearLayout.VERTICAL);
		consoleAlertLayout.addView(consoleSpinner);
		consoleAlertLayout.addView(consoleInputLayout);

		builder = new AlertDialog.Builder(this);
		builder.setTitle("Console Window - Enter Command")
		.setMessage("")
		.setView(consoleAlertLayout)
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				String message = consoleInputBox.getText().toString().trim();

				// remove it if already in history and add to end
				consoleInputBox.removeHistory(message);
				consoleInputBox.addHistory(message);
				
				nativeConsoleCommand(message);
				consoleInputBox.setText(" ");
				consoleSpinner.setSelection(0);
				consoleInputBox.setText("");
				dialog.dismiss();
				CurrentDialogType = EAlertDialogType.None;
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				consoleInputBox.setText(" ");
				consoleSpinner.setSelection(0);
				consoleInputBox.setText("");
				dialog.dismiss();
				CurrentDialogType = EAlertDialogType.None;
			}
		});
		consoleAlert = builder.create();

		virtualKeyboardInputBox = new EditText(this);
		virtualKeyboardInputBox.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				String message = virtualKeyboardInputBox.getText().toString();
				nativeVirtualKeyboardChanged(message);
			}

			@Override
			public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
			}
		});

		builder = new AlertDialog.Builder(this);
		builder.setTitle("")
		.setView(virtualKeyboardInputBox)
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				String message = virtualKeyboardInputBox.getText().toString();
				nativeVirtualKeyboardResult(true, message);
				virtualKeyboardInputBox.setText(" ");
				dialog.dismiss();
				CurrentDialogType = EAlertDialogType.None;
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				nativeVirtualKeyboardChanged(virtualKeyboardPreviousContents);
				nativeVirtualKeyboardResult(false, " ");
				virtualKeyboardInputBox.setText(" ");
				dialog.dismiss();
				CurrentDialogType = EAlertDialogType.None;
			}
		});
		virtualKeyboardAlert = builder.create();

		GooglePlayLicensing.GoogleLicensing = new GooglePlayLicensing();
		GooglePlayLicensing.GoogleLicensing.Init(this, Log);

		// Now okay for event handler to be set up on native side
		//	nativeResumeMainInit();
				
		// Try to establish a connection to Google Play
		// AndroidThunkJava_GooglePlayConnect();

		// If we have data in the apk or just loose then carry on init as normal
		/*Log.debug(this.getObbDir().getAbsolutePath());
		String path = this.getObbDir().getAbsolutePath() + "/main.1.com.epicgames.StrategyGame.obb";
		File obb = new File(path);
		Log.debug("=+=+=+=+=+=+=> File exists: " + (obb.exists() ? "True" : "False"));
		*/
		if(PackageDataInsideApkValue == 1 || HasOBBFiles == 0)
		{
			HasAllFiles = true;
		}

		// check for OBB file present if we don't have all the files and don't need to verify
		if (!HasAllFiles && !VerifyOBBOnStartUp)
		{
			HasAllFiles = DownloadShim.expansionFilesDelivered(this, VersionCode);
		}

		containerFrameLayout = new FrameLayout(_activity);
		virtualKeyboardLayout = new LinearLayout(_activity);

		// Need to create our surface view here regardless of if we are going to end up using it
		getWindow().takeSurface(null);
		MySurfaceView = new SurfaceView(this);
		MySurfaceView.setBackgroundColor(Color.TRANSPARENT);
		MySurfaceView.getHolder().addCallback(this);
		containerFrameLayout.addView(MySurfaceView);
		containerFrameLayout.addView(virtualKeyboardLayout);
		setContentView(containerFrameLayout);

		// cache a reference to the main content view and set it so it can be focused on
        mainView = findViewById( android.R.id.content );
        mainView.setFocusable( true );
        mainView.setFocusableInTouchMode( true );

        mainDecorView = getWindow().getDecorView();
		mainDecorViewRect = new Rect();
		
		// check for display cutouts to set safe zone
		View mainRootView = mainDecorView.findViewById(android.R.id.content).getRootView();
		if (Build.VERSION.SDK_INT > 19)
		{
			mainRootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
				@Override
       			public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
					if (Build.VERSION.SDK_INT >= 28)
					{
						DisplayCutout cutout = insets.getDisplayCutout();
						if (cutout != null)
						{
							Rect fullViewRect = new Rect();
							mainDecorView.getDrawingRect( mainDecorViewRect );

							android.view.Display display = getWindowManager().getDefaultDisplay();
							android.graphics.Point displaySize = new android.graphics.Point();
							display.getRealSize(displaySize);

							// store safezone independent of resolution
							float invX = 1.0f / (displaySize.x != 0.0f ? displaySize.x : 1.0f);
							float invY = 1.0f / (displaySize.y != 0.0f ? displaySize.y : 1.0f);
							safezoneF.left = (safezone.left = cutout.getSafeInsetLeft()) * invX;
							safezoneF.top = (safezone.top = cutout.getSafeInsetTop()) * invY;
							safezoneF.right = (safezone.right = cutout.getSafeInsetRight()) * invX;
							safezoneF.bottom = (safezone.bottom = cutout.getSafeInsetBottom()) *invY;
							nativeSetSafezoneInfo(displaySize.y > displaySize.x, safezoneF.left, safezoneF.top, safezoneF.right, safezoneF.bottom);

							//Log.debug("FullViewRect: " + fullViewRect.toString());	
							//Log.debug("DisplayCutout: " + cutout.toString());
							//Log.debug("SafeTop: " + cutout.getSafeInsetTop());
							//Log.debug("SafeBottom: " + cutout.getSafeInsetBottom());
							//Log.debug("SafeLeft: " + cutout.getSafeInsetLeft());
							//Log.debug("SafeRight: " + cutout.getSafeInsetRight());
							//List<Rect>bounds = cutout.getBoundingRects();
							//for (Rect r : bounds)
							//{
							//	Log.debug("Rect: " + r.toString());
							//}
						}
					}
					return insets;
				}
			});
		}

		createVirtualKeyboardInput();
		
		mainView.getViewTreeObserver().addOnGlobalLayoutListener( new ViewTreeObserver.OnGlobalLayoutListener()
        {
        	@Override
        	public void onGlobalLayout()
        	{
				//Log.debug("VK: onGlobalLayout " + bKeyboardShowing);
        		//if( bKeyboardShowing )
        		{
        			Rect visibleRect = new Rect();
        			View visibleView = mainView.getRootView();

        			visibleView.getWindowVisibleDisplayFrame( visibleRect );

					mainDecorView.getDrawingRect( mainDecorViewRect );

					//Log.debug("VK: onGlobalLayout visibleRect:(" +  visibleRect.left + ", " + visibleRect.top +", " + visibleRect.right +", " + visibleRect.bottom +")"+
        			//", mainDecorViewRect:" +  mainDecorViewRect.left + ", " + mainDecorViewRect.top +", " + mainDecorViewRect.right +", " + mainDecorViewRect.bottom + ")" );

        			// determine which side of the screen the keyboard is covering
        			int leftDiff = Math.abs( mainDecorViewRect.left - visibleRect.left );
        			int topDiff = Math.abs( mainDecorViewRect.top - visibleRect.top );
        			int rightDiff = Math.abs( mainDecorViewRect.right - visibleRect.right );
        			int bottomDiff = Math.abs( mainDecorViewRect.bottom - visibleRect.bottom );

        			// Rect covered by the virtual keyboard
        			Rect keyboardRect = new Rect();
    				keyboardRect.left = ( rightDiff > 0 ) ? visibleRect.right : mainDecorViewRect.left; // keyboard is on the right
    				keyboardRect.top = ( bottomDiff > 0 ) ? visibleRect.bottom : mainDecorViewRect.top; // keyboard is on the bottom
    				keyboardRect.right = ( leftDiff > 0 ) ? visibleRect.left : mainDecorViewRect.right; // keyboard is on the left
    				keyboardRect.bottom = ( topDiff > 0 ) ? visibleRect.top : mainDecorViewRect.bottom; // keyboard is on the top

					//keyboard Y coord
					int keyboardYPos = visibleRect.bottom - newVirtualKeyboardInput.getHeight();

					//avoid negative coords if the keyboard is shown on top of the screen
					if(keyboardYPos < 0)
						keyboardYPos = visibleRect.top + newVirtualKeyboardInput.getHeight();

                    int visibleScreenYOffset = Math.max(bottomDiff, topDiff);

					//Log.debug("VK: show?" + visibleScreenYOffset + "," + newVirtualKeyboardInput.getY());
					
					// If the keyboard is a soft keyboard, the visibleScreenYOffset should be greater than 200 tall
					boolean bSoftKeyboardPopup = visibleScreenYOffset > 200;

					// If the keyboard is a floating keyboard, after testing with some Chinese input methods the visibleScreenYOffset can be 0 pixel tall, expand it to [0, 200] for safety, correct this range if there is any unexpected case.
					boolean bFloatingKeyboardPopup = visibleScreenYOffset >= 0 && visibleScreenYOffset <= 200;

					if(bSoftKeyboardPopup || bFloatingKeyboardPopup) // actually this condition equals to the bKeyboardShowing, keep it in case we need to handle the different keyboards seperately.
                    {
						if (bKeyboardShowing)
						{
							nativeVirtualKeyboardShown( keyboardRect.left, keyboardRect.top, keyboardRect.right, keyboardRect.bottom );

							//Log.debug("VK: show");
							//#jira UE-55117 Android virtual keyboard can have text input hidden by software buttons
							newVirtualKeyboardInput.getLayoutParams().width = Math.abs(visibleRect.right - visibleRect.left);
							newVirtualKeyboardInput.setX(leftDiff);
							newVirtualKeyboardInput.setY(keyboardYPos);
							newVirtualKeyboardInput.setVisibility(View.VISIBLE);
							newVirtualKeyboardInput.requestFocus();
						}

						AndroidThunkJava_ResizeKeyboard(true, keyboardRect, visibleRect);
                    }
                    else
                    {
						if (bKeyboardShowing)
						{
							nativeVirtualKeyboardShown( keyboardRect.left, keyboardRect.top, keyboardRect.right, keyboardRect.bottom );
							
							if (newVirtualKeyboardInput.getY() > 0)
							{

								//Log.debug("VK: hide");
								newVirtualKeyboardInput.setVisibility(View.GONE);
								//set offscreen
								newVirtualKeyboardInput.setY(-1000);
							}
						}

						AndroidThunkJava_ResizeKeyboard(false, keyboardRect, visibleRect);
                    }
        		}
        	}
        });



		clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		
		if (Build.VERSION.SDK_INT >= 29)
		{
			PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
			powerManager.addThermalStatusListener(getMainExecutor(), new PowerManager.OnThermalStatusChangedListener() {
				@Override 
				public void onThermalStatusChanged(int status) 
				{
					Log.debug("=== Thermal status changed to " + status);
					nativeOnThermalStatusChangedListener(status);
				}
			});
		}

			//Google Play SDK onCreate additions
			try {
				GoogleApiClient.Builder gbuilder = new GoogleApiClient.Builder(this);
				gbuilder.addConnectionCallbacks(this);
				gbuilder.addOnConnectionFailedListener(this);
				gbuilder.addApiIfAvailable(Games.API, Games.SCOPE_GAMES);
				googleClient = gbuilder.build();
			}
			catch (Exception e)
			{
				Log.debug("GoogleApiClient exception caught: " + e.toString());
			}
			Log.debug("googleClient is " + ((googleClient == null) ? "disabled" : "valid"));


		
		Log.debug("==============> GameActive.onCreate complete!");
	}

	public void AndroidThunkJava_ResizeKeyboard(boolean bShow, Rect keyboardRect, Rect visibleRect)
	{
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
	}
	
	private Handler mRestoreImmersiveModeHandler = new Handler();
	private Runnable restoreImmersiveModeRunnable = new Runnable()
	{
		public void run() 
		{
			restoreTransparentBars();
		}
	};

	public void restoreTranslucentBarsDelayed()
	{
		// we restore it now and after 500 ms!
		restoreTransparentBars();
		mRestoreImmersiveModeHandler.postDelayed(restoreImmersiveModeRunnable, 500);
	}

	public void restoreTransparentBars()
	{
		if(android.os.Build.VERSION.SDK_INT >= 19) {
			try {
				View decorView = getWindow().getDecorView(); 

				Log.debug("=== Restoring Transparent Bars ===");
				// Clear the flag and then restore it
				decorView.setSystemUiVisibility(
								View.SYSTEM_UI_FLAG_LAYOUT_STABLE
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN
							/*| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY*/);
				
				decorView.setSystemUiVisibility(
								View.SYSTEM_UI_FLAG_LAYOUT_STABLE
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN
							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
				
			} catch (Exception e) {}
		}
	}

	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if(keyCode == KeyEvent.KEYCODE_BACK ||keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP)
		{
			if (ShouldHideUI)
			{
				Log.debug("=== Restoring Transparent Bars due to KeyCode ===");
				restoreTranslucentBarsDelayed();
			}
		}

		return super.onKeyDown(keyCode, event);
	}
	
	private void onResumeBody()
	{
		if (bAllowIMU)
		{
			Log.debug("Registering sensor listeners");
			if (accelerometer != null)
			{
				sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
			}
			if (magnetometer != null)
			{
				sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
			}
			if (gyroscope != null)
			{
				sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME);
			}
		}

		// invalidate window cache
		nativeSetWindowInfo(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT, DepthBufferPreference);

		// only do this on KitKat and above
		if (ShouldHideUI)
		{ 
			restoreTransparentBars();
			View decorView = getWindow().getDecorView(); 

			decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
				@Override 
				public void onSystemUiVisibilityChange(int visibility) 
				{
					Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
					restoreTransparentBars();
				}
			});

			decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) 
				{
					Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
					restoreTransparentBars();
				}
			});
		}

		// only true if Android Pie or later
		if (UseDisplayCutout)
		{
			// only on Android Pie and later
			WindowManager.LayoutParams params = getWindow().getAttributes();
			if (params.layoutInDisplayCutoutMode != WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES)
			{
				params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
				getWindow().setAttributes(params);
			}
		}

		if(HasAllFiles)
		{
			Log.debug("==============> Resuming main init");
			nativeResumeMainInit();
			InitCompletedOK = true;
		}
		else
		{
			nativeOnInitialDownloadStarted();

			// Post the check activity handler here to run after onResume completes
			Log.debug("==============> Posting request for downloader activity");
			final Handler downloadHandler = new Handler();
			downloadHandler.post(new Runnable() {
				@Override
				public void run() {
					Log.debug("==============> Starting activity to check files and download if required");
					Intent intent = new Intent(_activity, DownloadShim.GetDownloaderType());
					intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivityForResult(intent, DOWNLOAD_ACTIVITY_ID);
					if (noActionAnimID != -1) {
						overridePendingTransition(noActionAnimID, noActionAnimID);
					}
				}
			});
		}

		LocalNotificationCheckAppOpen();

		// Forcing this to false so the virtual keyboard can be shown again after resuming
		// since calls to showSoftInput are ignored on resume so have to make sure state is reset
		bKeyboardShowing = false;


		Log.debug("==============> GameActive.onResume complete!");
	}

	@Override
	public void onResume()
	{
		super.onResume();

		// start memory reporter timer (runs every 10 seconds)
		synchronized(this)
		{
			if (memoryHandler == null && memoryRunnable != null)
			{
				Log.debug("onResume: start memory reporter runnable");
				memoryHandler = new Handler(memoryHandlerThread.getLooper());
				memoryHandler.postDelayed(memoryRunnable, 1000);
			}
		}

		// only do this on KitKat and above
		if (ShouldHideUI)
		{ 
			restoreTransparentBars();
			View decorView = getWindow().getDecorView(); 

			decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
				@Override 
				public void onSystemUiVisibilityChange(int visibility) 
				{
					Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
					restoreTransparentBars();
				}
			});

			decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) 
				{
					Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
					restoreTransparentBars();
				}
			});
		}

		// only true if Android Pie or later
		if (UseDisplayCutout)
		{
			WindowManager.LayoutParams params = getWindow().getAttributes();
			if (params.layoutInDisplayCutoutMode != WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES)
			{
				params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
				getWindow().setAttributes(params);
			}
		}

		// restore screensaver state
		AndroidThunkJava_KeepScreenOn(bKeepScreenOn);
		
		// restore screep capture state
		SetDisableScreenCaptureInternal(AndroidThunkJava_IsScreenCaptureDisabled());

		if (bForceGameEndWithError || bForceGameEndWithWarning)
		{
			final boolean bWarning = bForceGameEndWithWarning;

			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					if (ForceGameDialog != null)
					{
						return;
					}

					AlertDialog.Builder dialog = new AlertDialog.Builder(_activity);
					dialog.setCancelable(false);
					dialog.setTitle(ForceExitCaption);
					dialog.setMessage(ForceExitMessage);
					if (!ForceExitLink.equals(""))
					{
						dialog.setNeutralButton(ForceExitHelpButtonText, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
								AndroidThunkJava_LaunchURL(ForceExitLink);
								AndroidThunkJava_ForceQuit();
							}
						});
					}
					if (bForceGameEndWithWarning)
					{
						dialog.setNegativeButton(ForceExitContinueButtonText, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
								ForceGameDialog = null;
								bForceGameEndWithWarning = false;
								onResumeBody();
							}
						});
					}
					if (!ForceExitUpdateButtonText.equals(""))
					{
						dialog.setPositiveButton(ForceExitUpdateButtonText, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
								// just open settings on Jellybean
								if (ANDROID_BUILD_VERSION >= 16 && ANDROID_BUILD_VERSION < 19)
								{
									AndroidThunkJava_OpenIntentAction("android.settings.SETTINGS");
								}
								else {
									// see if we can open directly to update settings
									if (AndroidThunkJava_isIntentActionAvailable("android.settings.SYSTEM_UPDATE_SETTINGS"))
									{
										AndroidThunkJava_OpenIntentAction("android.settings.SYSTEM_UPDATE_SETTINGS");
									}
									else {
										// fall back to just settings
										AndroidThunkJava_OpenIntentAction("android.settings.SETTINGS");
									}
								}
								AndroidThunkJava_ForceQuit();
							}
						});
					}
					else
					{
						dialog.setPositiveButton(ForceExitQuitButtonText, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
								AndroidThunkJava_ForceQuit();
							}
						});
					}

					ForceGameDialog = dialog.create();
					ForceGameDialog.show();
					return;
				}
			});

			return;
		}

		onResumeBody();
	}

	@Override
	protected void onPause()
	{
		// stop memory reporter timer if running
		synchronized(this)
		{
			if (memoryHandler != null)
			{
				Log.debug("onPause: stop memory reporter runnable");
				memoryHandler.removeCallbacks(memoryRunnable);
				memoryHandler = null;
			}
		}

		if (bAllowIMU)
		{
			Log.debug("Unregistering sensor listeners");
			sensorManager.unregisterListener(this);
		}

		// hide virtual keyboard before going into the background
		if( bKeyboardShowing )
		{
			AndroidThunkJava_HideVirtualKeyboardInput();
		}

		if(CurrentDialogType != EAlertDialogType.None)
		{
			//	If an AlertDialog is showing when the application is paused, it can cause our main window to be terminated
			//	Hide the dialog here. It will be shown again via AndroidThunkJava_ShowHiddenAlertDialog called from native code
			_activity.runOnUiThread(new Runnable()
			{
				public void run()
				{
					switch(CurrentDialogType)
					{
						// this hides the old alert dialog that was used for input
						case Keyboard:
							virtualKeyboardAlert.hide(); 
							break;
						case Console:
							consoleAlert.hide(); 
							break;
						default:
							Log.debug("ERROR: Unknown EAlertDialogType!");
							break;
					}
				}
			});
		}

		super.onPause();
		Log.debug("==============> GameActive.onPause complete!");
	}

	@Override
	public void onRestart()
	{
		super.onRestart();

	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)
	{
		super.onSaveInstanceState(outState, outPersistentState);

	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
	{
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

	}
	
	@Override
	public void onSensorChanged(SensorEvent event)
	{
		if (bAllowIMU && accelerometer != null && magnetometer != null)
		{
			boolean bUpdate = false;
			boolean bGyroUpdate = false;

			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
			{
				System.arraycopy(event.values, 0, current_accelerometer, 0, 3);
				bUpdate = true;

				// We use a low-pass filter to synthesize the gravity vector.
				if (!first_acceleration_sample)
				{
					filtered_gravity[0] = last_gravity[0] * SampleDecayRate + current_accelerometer[0]*(1.0f - SampleDecayRate);
					filtered_gravity[1] = last_gravity[1] * SampleDecayRate + current_accelerometer[1]*(1.0f - SampleDecayRate);
					filtered_gravity[2] = last_gravity[2] * SampleDecayRate + current_accelerometer[2]*(1.0f - SampleDecayRate);
				}
				first_acceleration_sample = false;
				last_gravity = filtered_gravity;
			}
			else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
			{
				System.arraycopy(event.values, 0, current_magnetometer, 0, 3);
				bUpdate = true;
			}
			else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
			{
				System.arraycopy(event.values, 0, current_gyroscope, 0, 3);
				bUpdate = true;
				bGyroUpdate = true;
			}

			// If we have motion samples we generate the single event.
			if (bUpdate)
			{
				// get the rotation matrix value, the convert those to Euler angle rotation values
				sensorManager.getRotationMatrix(rotationMatrix, null, current_accelerometer, current_magnetometer);
				sensorManager.getOrientation(rotationMatrix, orientationAngles);

				// protect against request from other thread
				synchronized(this)
				{
					// remember gravity
					current_gravity = filtered_gravity;

					// fix up the tilt mapping to proper coordinate frame
					current_tilt[0] = orientationAngles[1];
					current_tilt[1] = orientationAngles[2];
					current_tilt[2] = orientationAngles[0];

					// And take out the gravity from the accel to get the linear acceleration.
					current_acceleration[0] = current_accelerometer[0] - current_gravity[0];
					current_acceleration[1] = current_accelerometer[1] - current_gravity[1];
					current_acceleration[2] = current_accelerometer[2] - current_gravity[2];

					// Figure out the rotation rate
					if (bGyroUpdate)
					{
						// The rotation rate is the what the gyroscope gives us.
						current_rotation_rate = current_gyroscope;
					}
					else if (null == gyroscope)
					{
						// If we don't have a gyroscope at all we need to calc a rotation rate from delta from previous tilt.
						current_rotation_rate[0] = current_tilt[0] - last_tilt[0];
						current_rotation_rate[1] = current_tilt[1] - last_tilt[1];
						current_rotation_rate[2] = current_tilt[2] - last_tilt[2];
					}
					last_tilt = current_tilt;
				}

				// flag new sensor data ready
				bSensorDataUpdated = true;
			}
		}
	}

	public void AndroidThunkJava_PushSensorEvents()
	{
		if (bAllowIMU)
		{
			// protect against other thread updating the values
			synchronized(this)
			{
				if (bSensorDataUpdated)
				{
					nativeHandleSensorEvents(current_tilt, current_rotation_rate, current_gravity, current_acceleration);
					bSensorDataUpdated = false;
				}
			}
		}
	}

	@Override
	public void onNewIntent(Intent newIntent)
	{
		super.onNewIntent(newIntent);
		setIntent(newIntent);

	}

	public void onTrimMemory(int level)
	{
		// Determine which lifecycle or system event was raised.
		switch (level) {
			// user interface is in background, release UI memory
			case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_UI_HIDDEN) called!");
				break;

			// app is running but getting low on memory
			case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_MODERATE) called!");
				break;
			case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_LOW) called!");
				break;
			case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
				// system will begin killing background processes
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_RUNNING_CRITICAL) called!");
				break;

			// app is on LRU list (background), release what you can
			case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_BACKGROUND) called!");
				break;
			case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_MODERATE) called!");
				break;
			case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
				// this process up first to kill for more memory!
				Log.debug("==============> GameActive.onTrimMemory(TRIM_MEMORY_COMPLETE) called!");
				break;

			// unrecognized level; generic low memory situation
			default:
				Log.debug("==============> GameActive.onTrimMemory(" + level + ") called!");
				break;
		}
		nativeOnTrimMemory(level);
	}

	@Override
	public void onStop()
	{
		if (consoleCmdReceiver != null)
		{
			unregisterReceiver(consoleCmdReceiver);
		}


		super.onStop();
		Log.debug("==============> GameActive.onStop complete!");
	}

	@Override
	public void onDestroy()
	{
		synchronized(this)
		{
			if (memoryHandler != null)
			{
				Log.debug("onDestroy: destroy memoryHandler");
				memoryHandler.removeCallbacks(memoryRunnable);
				memoryHandler = null;
			}
			if (memoryHandlerThread != null)
			{
				Log.debug("onDestroy: destroy memoryHandlerThread");
				memoryHandlerThread.quit();
				memoryHandlerThread = null;
			}
		}

		if( IapStoreHelper != null )
		{
			IapStoreHelper.onDestroy();
		}

		super.onDestroy();
		Log.debug("==============> GameActive.onDestroy complete!");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);

		// forward the orientation
		boolean bPortrait = newConfig.orientation == Configuration.ORIENTATION_PORTRAIT;
		nativeOnConfigurationChanged(bPortrait);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		if(bUseSurfaceView)
		{
			int newWidth = (DesiredHolderWidth > 0) ? DesiredHolderWidth : width;
			int newHeight = (DesiredHolderHeight > 0) ? DesiredHolderHeight : height;

			super.surfaceChanged(holder, format, newWidth, newHeight);

			holder.setFixedSize(newWidth, newHeight);

			nativeSetSurfaceViewInfo(holder.getSurfaceFrame().width(), holder.getSurfaceFrame().height());
		}
		else
		{
			super.surfaceChanged(holder, format, width, height);
		}
	}

	public void AndroidThunkJava_ShowHiddenAlertDialog()
	{
		if(CurrentDialogType != EAlertDialogType.None)
		{
			Log.debug("==============> [JAVA] AndroidThunkJava_ShowHiddenAlertDialog() - Showing " + CurrentDialogType);
		
			//	If an AlertDialog was showing onPause and we hid it, show it again
			_activity.runOnUiThread(new Runnable()
			{
				public void run()
				{
					switch(CurrentDialogType)
					{
						case Keyboard:
							virtualKeyboardAlert.show(); 
							break;
						case Console:
							consoleAlert.show(); 
							break;
						default:
							Log.debug("ERROR: Unknown EAlertDialogType!");
							break;
					}
				}
			});
		}
	}

	public boolean AndroidThunkJava_IsScreensaverEnabled()
	{
		return !bKeepScreenOn;
	}

	public void AndroidThunkJava_KeepScreenOn(boolean Enable)
	{
		bKeepScreenOn = Enable;
		if (Enable)
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(true) - Disabled screen saver");
					_activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				}
			});
		}
		else
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					Log.debug("==============> [JAVA] AndroidThunkJava_KeepScreenOn(false) - Enabled screen saver");
					_activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				}
			});
		}
	}

	public boolean AndroidThunkJava_IsScreenCaptureDisabled()
	{
		return NumTimesScreenCaptureDisabled != 0;
	}

	private void SetDisableScreenCaptureInternal(boolean bDisable)
	{
		if (bDisable)
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(true) - Disabled screen captures");
					_activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
				}
			});
		}
		else
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					Log.debug("==============> [JAVA] AndroidThunkJava_DisableScreenCapture(false) - Enabled screen captures");
					_activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
				}
			});
		}
	}

	public void AndroidThunkJava_DisableScreenCapture(boolean bDisable)
	{
		boolean bWasDisabled = AndroidThunkJava_IsScreenCaptureDisabled();
		NumTimesScreenCaptureDisabled += bDisable ? 1 : -1;
		// Change in state?
		if (AndroidThunkJava_IsScreenCaptureDisabled() != bWasDisabled)
		{
			SetDisableScreenCaptureInternal(!bWasDisabled);
		}
	}

	private class VibrateRunnable implements Runnable {
		private int duration;
		private Vibrator vibrator;

		VibrateRunnable(final int Duration, final Vibrator vibrator)
		{
			this.duration = Duration;
			this.vibrator = vibrator;
		}
		public void run ()
		{
			if (duration < 1)
			{
				vibrator.cancel();
			} else {
				vibrator.vibrate(duration);
			}
		}
	}

	public void AndroidThunkJava_Vibrate(int Duration)
	{
		Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
		if (vibrator != null)
		{
			_activity.runOnUiThread(new VibrateRunnable(Duration, vibrator));
		}
	}

	// Called from event thread in NativeActivity	
	public void AndroidThunkJava_ShowConsoleWindow(String Formats)
	{
		if (consoleAlert.isShowing() == true)
		{
			Log.debug("Console already showing.");
			return;
		}

		// start at end of console history
		consoleInputBox.setHistoryEnd();

		consoleAlert.setMessage("[Available texture formats: " + Formats + "]");
		_activity.runOnUiThread(new Runnable()
		{
			public void run()
			{
				if (consoleAlert.isShowing() == false)
				{
					Log.debug("Console not showing yet");
					consoleAlert.show(); 
					CurrentDialogType = EAlertDialogType.Console;
				}
			}
		});
	}

	// old virtual keyboard show/hide functions input dialog
	public void AndroidThunkJava_HideVirtualKeyboardInputDialog()
	{
		if (virtualKeyboardAlert.isShowing() == false)
		{
			Log.debug("Virtual keyboard already hidden.");
			return;
		}

		_activity.runOnUiThread(new Runnable()
		{
			public void run()
			{
				if (virtualKeyboardAlert.isShowing() == true)
				{
					Log.debug("Virtual keyboard hiding");
					virtualKeyboardInputBox.setText(" ");
					virtualKeyboardAlert.dismiss();
					CurrentDialogType = EAlertDialogType.None;
				}
			}
		});
	}

	public void AndroidThunkJava_ShowVirtualKeyboardInputDialog(int inInputType, String inLabel, String inContents)
	{
		if (virtualKeyboardAlert.isShowing() == true)
		{
			Log.debug("Virtual keyboard already showing.");
			return;
		}

		// Capture to pass into ui thread
		final int uiInputType = inInputType;
		final String uiLabel = inLabel;
		final String uiContents = inContents;

		_activity.runOnUiThread(new Runnable()
		{
			public void run()
			{
				// Set label and starting contents
				virtualKeyboardAlert.setTitle(uiLabel);

				// Ensure the input mode of the text box is set before setting the contents.
				// configure for type of input
				virtualKeyboardInputBox.setRawInputType(uiInputType);
				virtualKeyboardInputBox.setTransformationMethod((uiInputType & InputType.TYPE_TEXT_VARIATION_PASSWORD) == 0 ? null : PasswordTransformationMethod.getInstance());

				virtualKeyboardInputBox.setText("");
				virtualKeyboardInputBox.append(uiContents);
				virtualKeyboardPreviousContents = uiContents;

				if (virtualKeyboardAlert.isShowing() == false)
				{
					Log.debug("Virtual keyboard not showing yet");
					virtualKeyboardAlert.show(); 
					CurrentDialogType = EAlertDialogType.Keyboard;
				}
			}
		});
	}

	// new functions to show/hide virtual keyboard
	public void AndroidThunkJava_HideVirtualKeyboardInput()
	{
		//Log.debug("VK: AndroidThunkJava_HideVirtualKeyboardInput");

		//#jira UE-49143 Inconsistent virtual keyboard behavior tapping between controls
		lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_HIDE;
		virtualKeyboardHandler.removeCallbacksAndMessages(null) ;
		virtualKeyboardHandler.postDelayed(new Runnable()
		{
			public void run()
			{
				if(lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_HIDE)
				{
					processLastVirtualKeyboardCommand();
				}
			}
		}, lastVirtualKeyboardCommandDelay);
	}

	//initial settings for the virtual input
	String virtualKeyboardInputContent;
	int virtualKeyboardInputType;
	public void AndroidThunkJava_ShowVirtualKeyboardInput(int inInputType, String Label, String Contents)
	{
		//Log.debug("VK: AndroidThunkJava_ShowVirtualKeyboardInput");
		virtualKeyboardInputContent = Contents;
		virtualKeyboardInputType = inInputType;
		lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_SHOW;
		//#jira UE-49143 Inconsistent virtual keyboard behavior tapping between controls
		virtualKeyboardHandler.removeCallbacksAndMessages(null) ;
		virtualKeyboardHandler.postDelayed(new Runnable()
		{
			public void run()
			{
				if(lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_SHOW)
				{
					processLastVirtualKeyboardCommand();
				}
			}
		}, lastVirtualKeyboardCommandDelay);
	}
	
	//jira UE-49141 Virtual keyboard is unresponsive with repeated tapping in control (some devices)
	//#jira UE-49139 Tapping in the same text box doesn't make the virtual keyboard disappear
	public void processLastVirtualKeyboardCommand()
	{
		Log.debug("VK: process last command " + lastVirtualKeyboardCommand);
		synchronized(this) {
			switch(lastVirtualKeyboardCommand)	
			{
				case VK_CMD_SHOW:
				{
					newVirtualKeyboardInput.setVisibility(View.VISIBLE);
				
					//newVirtualKeyboardInput.setBackgroundColor(Color.TRANSPARENT);
					//newVirtualKeyboardInput.setCursorVisible(false);

					//set offscreen
					newVirtualKeyboardInput.setY(-1000);

					//set new content
					newVirtualKeyboardInput.setText(virtualKeyboardInputContent);
				
					int newVirtualKeyboardInputType = virtualKeyboardInputType;

					//commented: as it will disable text prediction for all devices, 
					//	for most of them it will also block the VK in latin/english subtype
					//	disabling chinese or korean subtypes
					//if((virtualKeyboardInputType & InputType.TYPE_TEXT_VARIATION_PASSWORD) == 0)
					//{
						//#jira UE-49117 Chinese and Korean virtual keyboards don't allow native characters
						//#jira UE-49121 Gboard and Swift swipe entry are not supported by Virtual keyboard
						//newVirtualKeyboardInputType |= TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
					//}

					//TYPE: disable text suggestion
					newVirtualKeyboardInputType |= InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;
				
					//TYPE: set input type flags
					newVirtualKeyboardInput.setInputType(newVirtualKeyboardInputType);
					newVirtualKeyboardInput.setRawInputType(newVirtualKeyboardInputType);

					//IME: set Done button for single line input
					int imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI;


					if (ANDROID_BUILD_VERSION >=  11)
					{
						imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
					}

					//IME: set single/multi line input type
					if((virtualKeyboardInputType & InputType.TYPE_TEXT_FLAG_MULTI_LINE) != 0)
					{
						//disable enter for multi-line - will be treated by virtualKeyboardInputType in sendKeyEvent
						newVirtualKeyboardInput.setSingleLine(false);
						//#jira UE-49128 Virtual Keyboard text field doesn't appear if there is too much text
						newVirtualKeyboardInput.setMaxLines(5);
						imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
						imeOptions &= ~EditorInfo.IME_ACTION_DONE;
					}
					else
					{
						newVirtualKeyboardInput.setSingleLine(true);
						newVirtualKeyboardInput.setMaxLines(1);
						imeOptions &= ~EditorInfo.IME_FLAG_NO_ENTER_ACTION;
						imeOptions |= EditorInfo.IME_ACTION_DONE;
					}

					//IME: set IME flags
					newVirtualKeyboardInput.setImeOptions(imeOptions);

					//TRANSFORMATION: hide input for passwords
					newVirtualKeyboardInput.setTransformationMethod((
						virtualKeyboardInputType & InputType.TYPE_TEXT_VARIATION_PASSWORD) == 0 ? 
						null : 
						PasswordTransformationMethod.getInstance());

					//SELECTION: move to end
					newVirtualKeyboardInput.setSelection(newVirtualKeyboardInput.getText().length());

					if(newVirtualKeyboardInput.requestFocus())
					{
						//Log.debug("VK: Show newVirtualKeyboardInput");
						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.showSoftInput(newVirtualKeyboardInput, 0);

						nativeVirtualKeyboardVisible(true);
						bKeyboardShowing = true;

						CheckKeyboardDisplayed();
					}
				}
				break;
				case VK_CMD_HIDE:
				{
						if (bKeyboardShowing || newVirtualKeyboardInput.getVisibility() != View.GONE)
						{
							//Log.debug("VK: Hide newVirtualKeyboardInput");

							if (newVirtualKeyboardInput.hasFocus()) {
								try {
									newVirtualKeyboardInput.clearFocus();
								} catch (Exception e) {
									Log.warn("Unable to clear focus from virtualKeyboardInput");
								}
							}
							//set offscreen
							newVirtualKeyboardInput.setY(-1000);

							newVirtualKeyboardInput.setVisibility(View.GONE);

							InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
							imm.hideSoftInputFromWindow(newVirtualKeyboardInput.getWindowToken(), 0);

							nativeVirtualKeyboardVisible(false);
							bKeyboardShowing = false;
						}
				}
				break;
			}
		}
		lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
	}

	// timer to check if the onGlobalLayout callback was correctly called when displaying the virtual keyboard
	private void CheckKeyboardDisplayed()
	{
		virtualKeyboardHandler.postDelayed(new Runnable()
		{
			public void run() 
			{
				synchronized(this) 
				{
					if(bKeyboardShowing && newVirtualKeyboardInput.getY() < 0) 
					{
						//couldn't show the VK input. Force layout refresh
						mainView.requestLayout();
					}
				}
			}
		}, checkLastVirtualKeyboardCommandDelay);
	}

	private boolean AndroidThunkJava_isIntentActionAvailable(String intentAction)
	{
		Intent intent = new Intent(intentAction, null);
		List<android.content.pm.ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
	    return activities != null && activities.size() > 0;
	}

	public void AndroidThunkJava_OpenIntentAction(String intentAction)
	{
		Intent intent = new Intent(intentAction, null);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}

	public void AndroidThunkJava_LaunchURL(String URL)
	{
		Log.debug("[JAVA} AndroidThunkJava_LaunchURL: URL = " + URL);
		if (!URL.contains("://"))
		{
			// add http:// if there isn't a scheme before a colon
			if (URL.indexOf(":") < 1)
			{
				URL = "http://" + URL;
				Log.debug("[JAVA} AndroidThunkJava_LaunchURL: corrected URL = " + URL);
			}
		}
		try
		{
			Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(URL));
			BrowserIntent.addCategory(Intent.CATEGORY_BROWSABLE);

			// open browser on its own task
			BrowserIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			BrowserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
			
			// make sure there is a web browser to handle the URL before trying to start activity (or may crash!)
			if (BrowserIntent.resolveActivity(getPackageManager()) != null)
			{
				Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Starting activity");
				startActivity(BrowserIntent);
			}
			else
			{
				Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Could not find an application to receive the URL intent");
			}
		}
		catch (Exception e)
		{
			Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Failed with exception " + e.getMessage());
		}
	}

	public String AndroidThunkJava_GetAndroidId()
	{
		try {
			String androidId = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID);
			return androidId;
		} catch (Exception e) {
			Log.debug("GetAndroidId failed: " + e.getMessage());
		}
		return null;
	}

	public String AndroidThunkJava_GetFunnelId()
	{
		String funnelId = "";
		
		return funnelId;
	}

	public String AndroidThunkJava_GetLoginId()
	{
		String loginId = null;

	

		// check for existing GUID fallback in internal
		File file = new File(InternalFilesDir + "login-identifier.txt");
		if (file.exists())
		{
            BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				loginId = reader.readLine();
				reader.close();
				return loginId;
			} catch (IOException ie) {
				Log.debug("failed to read login-identifier.txt: " + ie);
			}
		}

		// check for one in external storage (and write to internal if found)
		file = new File(ExternalFilesDir + "login-identifier.txt");
		if (file.exists())
		{
            BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				loginId = reader.readLine();
				reader.close();
				writeLoginId(InternalFilesDir, loginId);
				return loginId;
			} catch (IOException ie) {
				Log.debug("failed to read login-identifier.txt: " + ie);
			}
		}

		// generate a GUID and save it for next run
		UUID uuid = UUID.randomUUID();
		loginId = uuid.toString();
		writeLoginId(InternalFilesDir, loginId);

		return loginId;
	}

	public static boolean writeFile(String filename, String contents)
	{
		File file = new File(filename);

		try
		{
			FileWriter outputWriter = new FileWriter(file);
			outputWriter.write(contents);
			outputWriter.close();
			return true;
		}
		catch (IOException e)
		{
			Log.debug("Exception: " + e);
		}
		return false;
	}	

	public void writeLoginId(String path, String id)
	{
		if (!writeFile(path + "/" + "login-identifier.txt", id))
		{
			Log.debug("failed to create login-identifier.txt");
		}
	}

	public void AndroidThunkJava_ShareURL(String URL, String Description, String Prompt, int LocationX, int LocationY)
	{
		Log.debug("[JAVA} AndroidThunkJava_ShareURL: URL = " + URL);

		File SharedFile = new File(URL);
		boolean bIsFile = SharedFile.exists();

		if (!bIsFile && !URL.contains("://"))
		{
			URL = "http://" + URL;
			Log.debug("[JAVA} AndroidThunkJava_ShareURL: corrected URL = " + URL);
		}

		try
		{
			Intent SendIntent = new Intent(Intent.ACTION_SEND);
			if (bIsFile)
			{
				// Note that the ".fileprovider" suffix is hardcoded
				String Authority = getApplicationContext().getPackageName() + ".fileprovider";
				Uri FileUri = FileProvider.getUriForFile(this, Authority, SharedFile);
				
				SendIntent.putExtra(Intent.EXTRA_STREAM, FileUri);
				SendIntent.setType(URLConnection.guessContentTypeFromName(URL));
				SendIntent.putExtra(Intent.EXTRA_TEXT, Description);
			}
			else
			{
				SendIntent.setType("text/plain");
				SendIntent.putExtra(Intent.EXTRA_SUBJECT, Description);
				SendIntent.putExtra(Intent.EXTRA_TEXT, URL);
			}
			
			Log.debug("[JAVA} AndroidThunkJava_ShareURL: Sharing URL");
			startActivity(Intent.createChooser(SendIntent, Prompt));
		}
		catch (Exception e)
		{
			Log.debug("[JAVA} AndroidThunkJava_ShareURL: Failed with exception " + e.getMessage());
		}
	}

	public void AndroidThunkJava_ResetAchievements()
	{
		/* Disable so don't need GET_ACCOUNTS - we don't need this
		try
        {
			String accesstoken = GetAccessToken();
			          
			if(!accesstoken.equals(""))
			{
				String ResetURL = "https://www.googleapis.com/games/v1management/achievements/reset?access_token=" + accesstoken;
				Log.debug("AndroidThunkJava_ResetAchievements: using URL " + ResetURL);

				URL url = new URL(ResetURL);
				HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

				try
				{
					urlConnection.setRequestMethod("POST");
					int status = urlConnection.getResponseCode();
					Log.debug("AndroidThunkJava_ResetAchievements: HTTP response is " + status);
				}
				finally
				{
					urlConnection.disconnect();
				}
			}
			else
			{
				Log.debug("AndroidThunkJava_ResetAchievements: Access Token not returned.  Possible reason is that android.permission.GET_ACCOUNTS is not granted.  Make sure to add in by going to Project settings > Android > Advanced Project Settings and check the box for \"Request Access Token On Connect\". ");
			}
        }
        catch(Exception e)
        {
            Log.debug("AndroidThunkJava_ResetAchievements failed: " + e.getMessage());
        }
		*/
		Log.debug("AndroidThunkJava_ResetAchievements: disabled");
	}

	// TODO: replace this with non-depreciated method (OK now for up to API-25)
	@TargetApi(23)
	private String GetAccessToken()
	{
		String accesstoken = "";

		try
        {
			if (PermissionHelper.checkPermission("android.permission.GET_ACCOUNTS") && googleClient != null)
			{
				String email = Plus.AccountApi.getAccountName(googleClient);
				Log.debug("GetAccessToken: using email " + email);

				accesstoken = GoogleAuthUtil.getToken(this, email, "oauth2:https://www.googleapis.com/auth/games");
			}
		}
		catch(Exception e)
        {
            Log.debug("GetAccessToken failed: " + e.getMessage());
        }

		return accesstoken;
	}

	public void AndroidThunkJava_GoogleClientConnect()
	{
		if (googleClient != null)
		{
			googleClient.connect();
		}
	}

	public void AndroidThunkJava_GoogleClientDisconnect()
	{
		if (googleClient != null)
		{
			googleClient.disconnect();
		}
	}

	// Google Client connected successfully
	@Override
	public void onConnected(Bundle connectionHint)
	{
		if (googleClient != null && googleClient.isConnected())
		{
			new Thread(new Runnable()
			{
				public void run()
				{
					/* Don't do this since deprecated and don't want to request GET_ACCOUNTS permission
					try
					{
						String accesstoken = GetAccessToken();
						if(!accesstoken.equals(""))
						{
							Log.debug("Google Client Connect using Access Token " + accesstoken);
							nativeGoogleClientConnectCompleted(true, accesstoken);
						}
						else
						{
							Log.debug("Google Client Connect succeeded but no access token returned");
							nativeGoogleClientConnectCompleted(true, "");
						}
					}
					catch (Exception e)
					{
						Log.debug("Google Client Connect failed: " + e.getMessage());

						nativeGoogleClientConnectCompleted(false, "");
					}
					*/
					nativeGoogleClientConnectCompleted(true, "NOT_ACQUIRED");
				}
			}).start();
		}
		else
		{
			nativeGoogleClientConnectCompleted(false, "");
		}
	}

	// Google Client connection failed
	@Override
	public void onConnectionFailed(ConnectionResult connectionResult)
	{
		Log.debug("Google Client Connect failed. Error Code: " + connectionResult.getErrorCode() + " Description: " + connectionResult.getErrorMessage());
		nativeGoogleClientConnectCompleted(false, "");
	}

	// Google Client connection suspended
	@Override
	public void onConnectionSuspended(int cause)
	{
		Log.debug("Google Client Connect Suspended: " + cause);
	}

	public AssetManager AndroidThunkJava_GetAssetManager()
	{
		if(AssetManagerReference == null)
		{
			Log.debug("No reference to asset manager found!");
		}

		return AssetManagerReference;
	}

	public static boolean isOBBInAPK()
	{
		Log.debug("Asking if osOBBInAPK? " + (PackageDataInsideApkValue == 1));
		return PackageDataInsideApkValue == 1;
	}

	public void AndroidThunkJava_Minimize()
	{
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
	}

	public void AndroidThunkJava_ForceQuit()
	{

		System.exit(0);
		// finish();
	}

	public void AndroidThunkJava_SetOrientation(int value)
	{
		final int orientation = value;
		_activity.runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				_activity.setRequestedOrientation( orientation );
			}
		});
	}

	// call back into native code from the Java UI thread, initializing any available VR HMD modules
	public void AndroidThunkJava_InitHMDs()
	{
		_activity.runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				nativeInitHMDs();
			}
		});
	}

	public static String AndroidThunkJava_GetFontDirectory()
	{
		// Parse and find the first known fonts directory on the device
		String[] fontdirs = { "/system/fonts", "/system/font", "/data/fonts" };

		String targetDir = null;

		for ( String fontdir : fontdirs )
        {
            File dir = new File( fontdir );

			if(dir.exists())
			{
				targetDir = fontdir;
				break;
			}
		}
		
		return targetDir + "/";
	}
	
	public static String getAppPackageName()
	{
		return appPackageName;
	}

	public boolean AndroidThunkJava_IsMusicActive()
	{
		AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
		return audioManager.isMusicActive();
	}
	
	// In app purchase functionality
	public void AndroidThunkJava_IapSetupService(String InProductKey)
	{
		if (getPackageManager().checkPermission("com.android.vending.BILLING", getPackageName()) == getPackageManager().PERMISSION_GRANTED)
		{
			IapStoreHelper = new GooglePlayStoreHelper(InProductKey, this, Log);
			if (IapStoreHelper != null)
			{
				Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Setup started");
			}
			else
			{
				Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Failed to setup IAP service");
			}
		}
		else
		{
			Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - You do not have the appropriate permission setup.");
			Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Please ensure com.android.vending.BILLING is added to the manifest.");
		}

	}
	

	private String[] CachedQueryProductIDs;
	public boolean AndroidThunkJava_IapQueryInAppPurchases(String[] ProductIDs)
	{
		Log.debug("[JAVA] - AndroidThunkJava_IapQueryInAppPurchases");
		CachedQueryProductIDs = ProductIDs;

		boolean bTriggeredQuery = false;
		if( IapStoreHelper != null )
		{
			bTriggeredQuery = true;

			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					IapStoreHelper.QueryInAppPurchases(CachedQueryProductIDs);
				}
			});
		}
		else
		{
			Log.debug("[JAVA] - Store Helper is invalid");
		}
		return bTriggeredQuery;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if( requestCode == DOWNLOAD_ACTIVITY_ID)
		{
			int errorCode = 0;
			if(resultCode == RESULT_OK)
			{
								
				errorCode = data.getIntExtra(DOWNLOAD_RETURN_NAME, DOWNLOAD_NO_RETURN_CODE);
				
				String logMsg = "DownloadActivity Returned with ";
				switch(errorCode)
				{
				case DOWNLOAD_FILES_PRESENT:
					logMsg += "Download Files Present";
					break;
				case DOWNLOAD_COMPLETED_OK:
					logMsg += "Download Completed OK";
					break;
				case DOWNLOAD_NO_RETURN_CODE:
					logMsg += "Download No Return Code";
					break;
				case DOWNLOAD_USER_QUIT:
					logMsg += "Download User Quit";
					break;
				case DOWNLOAD_FAILED:
					logMsg += "Download Failed";
					break;
				case DOWNLOAD_INVALID:
					logMsg += "Download Invalid";
					break;
				case DOWNLOAD_NO_PLAY_KEY:
					logMsg +="Download No Play Key";
					break;
				default:
					logMsg += "Unknown message!";
					break;
				}
				
				Log.debug(logMsg);
			}
			else
			{
				Log.debug("Download activity cancelled by user.");
				errorCode = DOWNLOAD_USER_QUIT;
			}
			
			nativeOnInitialDownloadCompleted();

			HasAllFiles = (errorCode == DOWNLOAD_FILES_PRESENT || errorCode == DOWNLOAD_COMPLETED_OK);
			
			if(errorCode == DOWNLOAD_NO_RETURN_CODE 
			|| errorCode == DOWNLOAD_USER_QUIT 
			|| errorCode == DOWNLOAD_FAILED 
			|| errorCode == DOWNLOAD_INVALID
			|| errorCode == DOWNLOAD_NO_PLAY_KEY)
			{
				finish();
				return;
			}
		}

		else
		{
			super.onActivityResult(requestCode, resultCode, data);
		}


		
		if(InitCompletedOK)
		{
			nativeOnActivityResult(this, requestCode, resultCode, data);
		}
	}
	
public boolean AndroidThunkJava_IapBeginPurchase(String ProductId, String AccountId)
{
	Log.debug("[JAVA] - AndroidThunkJava_IapBeginPurchase");
	boolean bTriggeredPurchase = false;
	if( IapStoreHelper != null )
	{
		// sha-256 the accountId and get the hex string representation
		String ObfuscatedAccountId = null;
		if (AccountId != null)
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] sha256hash = md.digest(AccountId.getBytes("UTF-8"));
				StringBuilder builder = new StringBuilder(sha256hash.length * 2);
				for (byte b : sha256hash)
				{
					builder.append(String.format("%02x", b));
				}
				ObfuscatedAccountId = builder.toString();
			}
			catch (NoSuchAlgorithmException ae)
			{
			}
			catch (UnsupportedEncodingException ee)
			{
			}
		}
		bTriggeredPurchase = IapStoreHelper.BeginPurchase(ProductId, ObfuscatedAccountId);
	}
	else
	{
		Log.debug("[JAVA] - Store Helper is invalid");
	}
	return bTriggeredPurchase;
}


	public boolean AndroidThunkJava_IapIsAllowedToMakePurchases()
	{
		Log.debug("[JAVA] - AndroidThunkJava_IapIsAllowedToMakePurchases");
		boolean bIsAllowedToMakePurchase = false;
		if( IapStoreHelper != null )
		{
			bIsAllowedToMakePurchase = IapStoreHelper.IsAllowedToMakePurchases();
		}
		else
		{
			Log.debug("[JAVA] - Store Helper is invalid");
		}
		return bIsAllowedToMakePurchase;
	}

	public boolean AndroidThunkJava_IapConsumePurchase(String purchaseToken)
	{
		Log.debug("[JAVA] - AndroidThunkJava_IapConsumePurchase " + purchaseToken);

		if( IapStoreHelper != null )
		{
			IapStoreHelper.ConsumePurchase(purchaseToken);
			return true;
		}

		Log.debug("[JAVA] - Store Helper is invalid");
		return false;
	}

	public boolean AndroidThunkJava_IapQueryExistingPurchases()
	{
		Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases");
		boolean bTriggeredQuery = false;
		if( IapStoreHelper != null )
		{
			Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases - Kick off logic here!");
			bTriggeredQuery = IapStoreHelper.QueryExistingPurchases();
		}
		else
		{
			Log.debug("[JAVA] - Store Helper is invalid");
		}
		return bTriggeredQuery;
	}

	public boolean AndroidThunkJava_IapRestorePurchases(String[] InProductIDs, boolean[] bConsumable)
	{
		Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases");
		boolean bTriggeredRestore = false;
		if( IapStoreHelper != null )
		{
			Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases - Kick off logic here!");
			bTriggeredRestore = IapStoreHelper.RestorePurchases(InProductIDs, bConsumable);
		}
		else
		{
			Log.debug("[JAVA] - Store Helper is invalid");
		}
		return bTriggeredRestore;
	}

	public void AndroidThunkJava_DismissSplashScreen()
	{
		if (mSplashDialog != null)
		{
			mSplashDialog.dismiss();
			mSplashDialog = null;
		}
	}

	public void AndroidThunkJava_ShowProgressDialog(boolean bShow, String message, boolean bHorizontal, int maxValue)
	{
		final boolean bShowFinal = bShow;
		final String messageFinal = message;
		final boolean bHorizontalFinal = bHorizontal;
		final int maxValueFinal = maxValue;
		_activity.runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (bShowFinal)
				{
					mProgressDialog = new ProgressDialog(_activity);
					mProgressDialog.setMessage(messageFinal);
					mProgressDialog.setProgress(0);
					mProgressDialog.setMax(maxValueFinal);
					mProgressDialog.setProgressStyle(bHorizontalFinal ? ProgressDialog.STYLE_HORIZONTAL : ProgressDialog.STYLE_SPINNER);
					//mProgressDialog.setIndeterminate(true);
					// Setting NOT_FOCUSABLE prevents the splash dialog from kicking some devices out of immersive mode.
					mProgressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
					mProgressDialog.show();
				}
				else
				{
					mProgressDialog.dismiss();
					mProgressDialog = null;
				}
			}
		});
	}

	public void AndroidThunkJava_UpdateProgressDialog(int value)
	{
		if (mProgressDialog == null)
		{
			return;
		}
		final int valueFinal = value;
		_activity.runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				if (mProgressDialog != null)
				{
					mProgressDialog.setProgress(valueFinal);
				}
			}
		});
	}

	private static class DeviceInfoData {
		public final int vendorId;
		public final int productId;
		public final String name;

		DeviceInfoData(int vid, int pid, String inName)
		{
			vendorId = vid;
			productId = pid;
			name = inName;
		}

		boolean IsMatch(int vid, int pid)
		{
			return (vendorId == vid && productId == pid);
		}
	}

	private void LocalNotificationCheckAppOpen()
	{
		localNotificationAppLaunched = false;
		localNotificationLaunchActivationEvent = "";
		localNotificationLaunchFireDate = 0;

		Intent launchIntent = getIntent();
		if (launchIntent != null)
		{	
			Bundle extrasBundle = launchIntent.getExtras();

			localNotificationAppLaunched = launchIntent.getBooleanExtra("localNotificationAppLaunched", false);
			if (localNotificationAppLaunched)
			{
				localNotificationLaunchActivationEvent = extrasBundle.getString("localNotificationLaunchActivationEvent");
				if (localNotificationLaunchActivationEvent != null)
				{
					int notificationID = extrasBundle.getInt("localNotificationID");
					LocalNotificationRemoveID(this, notificationID);

					// TODO
					localNotificationLaunchFireDate = 0; 
				}
				else
				{
					localNotificationAppLaunched = false;
					localNotificationLaunchActivationEvent = "";
				}
			}
		}
	}

	public static int LocalNotificationGetID(Context context)
	{
		SharedPreferences preferences = context.getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		String notificationIDs = preferences.getString("notificationIDs", "");

		int idToReturn = 1;
		if(notificationIDs.length() == 0)
		{
			editor.putString("notificationIDs", Integer.toString(idToReturn));
		}
		else
		{
			String[] parts = notificationIDs.split("-");
			ArrayList<Integer> iParts = new ArrayList<Integer>();
			for(String part : parts)
			{
				if(part.length() > 0)
				{
					iParts.add(Integer.parseInt(part));
				}
			}
			while(true)
			{
				if(!iParts.contains(idToReturn))
				{
					break;
				}
				idToReturn++;
			}
			editor.putString("notificationIDs", notificationIDs + "-" + idToReturn);
		}
		editor.commit();

		return idToReturn;
	}

	private ArrayList<Integer> LocalNotificationGetIDList()
	{
		SharedPreferences preferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		String notificationIDs = preferences.getString("notificationIDs", "");
		ArrayList<Integer> iParts = new ArrayList<Integer>();

		String[] parts = notificationIDs.split("-");
		for(String part : parts)
		{
			if(part.length() > 0)
			{
				iParts.add(Integer.parseInt(part));
			}
		}

		return iParts;
	}

	private boolean LocalNotificationIDExists(int notificationID)
	{
		if (notificationID == -1)
		{
			return false;
		}

		ArrayList<Integer> notificationIDs = LocalNotificationGetIDList();

		for(int id : notificationIDs)
		{
			if (id == notificationID)
			{
				return true;
			}
		}
		return false;
	}

	public static void LocalNotificationRemoveID(Context context, int notificationID)
	{
		SharedPreferences preferences = context.getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		String notificationIDs = preferences.getString("notificationIDs", "");

		ArrayList<String> iParts = new ArrayList<String>();

		if(notificationIDs.length() == 0)
		{
			return;
		}
		else
		{
			String[] parts = notificationIDs.split("-");
			for(String part : parts)
			{
				if(part.length() > 0)
				{
					iParts.add(part);
				}
			}
			iParts.remove(Integer.toString(notificationID));
		}

		String newNotificationIDs = "";
		for(String notifID : iParts)
		{
			if(newNotificationIDs.length() == 0)
			{
				newNotificationIDs = notifID;
			}
			else
			{
				newNotificationIDs += "-" + notifID;
			}
		}

		editor.putString("notificationIDs", newNotificationIDs);
		editor.commit();
	}
	
	public static void LocalNotificationRemoveDetails(Context context, int notificationID)
	{
		SharedPreferences preferences = context.getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();

		try
		{
			JSONObject notificationDetails = new JSONObject(preferences.getString("notificationDetails", "{}"));
			notificationDetails.remove(String.valueOf(notificationID));
			editor.putString("notificationDetails", notificationDetails.toString());
			editor.commit();
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
	}

	public int AndroidThunkJava_LocalNotificationScheduleAtTime(String targetDateTime, boolean localTime, String title, String body, String action, String activationEvent) 
	{
		int notificationID = LocalNotificationGetID(this);

		if (!LocalNotificationScheduleAtTime(this, notificationID, targetDateTime, localTime, title, body, action, activationEvent))
		{
			return -1;
		}

		// Store notification details
		SharedPreferences preferences = getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		JSONObject notificationDetails;
		try
		{
			notificationDetails = new JSONObject(preferences.getString("notificationDetails", "{}"));
		}
		catch (JSONException e)
		{
			e.printStackTrace(); 
			notificationDetails = new JSONObject();
		}
		JSONObject details = new JSONObject();
		try
		{
			details.put("local-notification-targetDateTime", targetDateTime);
			details.put("local-notification-localTime", localTime);
			details.put("local-notification-title", title);
			details.put("local-notification-body", body);
			details.put("local-notification-action", action);
			details.put("local-notification-activationEvent", activationEvent);
			notificationDetails.put(String.valueOf(notificationID), details);
			editor.putString("notificationDetails", notificationDetails.toString());
			editor.commit();
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}

		return notificationID;
	}

	public static boolean LocalNotificationScheduleAtTime(Context context, int notificationID, String targetDateTime, boolean localTime, String title, String body, String action, String activationEvent)
	{
		// Create callback for PendingIntent
		Intent notificationIntent = new Intent(context, LocalNotificationReceiver.class);

		// Add user-provided data
		notificationIntent.putExtra("local-notification-ID", notificationID);
		notificationIntent.putExtra("local-notification-title", title);
		notificationIntent.putExtra("local-notification-body", body);
		notificationIntent.putExtra("local-notification-action", action);
		notificationIntent.putExtra("local-notification-activationEvent", activationEvent);

		// Designate the callback as a PendingIntent
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notificationID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		TimeZone targetTimeZone = TimeZone.getTimeZone("UTC");

		if(localTime) 
		{
			targetTimeZone = TimeZone.getDefault();
		}

		DateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		targetDateFormat.setTimeZone(targetTimeZone);

		Date targetDate = new Date();

		try 
		{
			targetDate = targetDateFormat.parse(targetDateTime);
		} 

		catch (ParseException e) 
		{
			e.printStackTrace();
			LocalNotificationRemoveID(context, notificationID);
			return false;
		}

		Date currentDate = new Date();

		long msDiff = targetDate.getTime() - currentDate.getTime();

		if(msDiff < 0)
		{
			LocalNotificationRemoveID(context, notificationID);
			return false;
		}

		long futureTimeInMillis = SystemClock.elapsedRealtime() + msDiff;//Calculate the time to run the callback
		AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

		//Schedule the operation by using AlarmService
		alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureTimeInMillis, pendingIntent);

		return true;
	}

	public class LaunchNotification {
		public boolean	used;
		public String	event;
		public int		fireDate;

		LaunchNotification(boolean inUsed, String inEvent, int inFireDate)
		{
			used = inUsed;
			event = inEvent;
			fireDate = inFireDate;
		}
	}

	public LaunchNotification AndroidThunkJava_LocalNotificationGetLaunchNotification()
	{
		return new LaunchNotification(localNotificationAppLaunched, localNotificationLaunchActivationEvent, localNotificationLaunchFireDate);
	}

	public void AndroidThunkJava_LocalNotificationClearAll()
	{
		ArrayList<Integer> idList = LocalNotificationGetIDList(); 

		for(int curID : idList)
		{
			AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(this, curID, new Intent(this, LocalNotificationReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);
			pendingIntent.cancel();
			alarmManager.cancel(pendingIntent);
		}

		// clear them all
		SharedPreferences preferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("notificationIDs", "");
		editor.putString("notificationDetails", "{}");
		editor.commit();
	}

	public boolean AndroidThunkJava_LocalNotificationExists(int notificationId)
	{
		return LocalNotificationIDExists(notificationId);
	}

	// Returns true only if the scheduled notification exists and gets destoyed successfully
	public boolean AndroidThunkJava_LocalNotificationDestroyIfExists(int notificationId)
	{
		if (AndroidThunkJava_LocalNotificationExists(notificationId))
		{
			LocalNotificationRemoveID(this, notificationId);
			LocalNotificationRemoveDetails(this, notificationId);

			//Cancel the intent itself as well as from the alarm manager
			AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(this, notificationId, new Intent(this, LocalNotificationReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);
			pendingIntent.cancel();
			alarmManager.cancel(pendingIntent);
			
			//Also clear the notification if currently displayed
			NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			notificationManager.cancel(notificationId);
			return true;
		}
		return false;
	}

	// List of vendor/product ids
	private static final DeviceInfoData[] DeviceInfoList = {
		new DeviceInfoData(0x04e8, 0xa000, "Samsung Game Pad EI-GP20"),
		new DeviceInfoData(0x0955, 0x7203, "NVIDIA Corporation NVIDIA Controller v01.01"),
		new DeviceInfoData(0x0955, 0x7210, "NVIDIA Corporation NVIDIA Controller v01.03"),
		new DeviceInfoData(0x1949, 0x0404, "Amazon Fire TV Remote"),
		new DeviceInfoData(0x1949, 0x0406, "Amazon Fire Game Controller"),
		new DeviceInfoData(0x0738, 0x5263, "Mad Catz C.T.R.L.R (Smart)"),
		new DeviceInfoData(0x0738, 0x5266, "Mad Catz C.T.R.L.R"),
		new DeviceInfoData(0x045e, 0x028e, "Xbox Wired Controller"),
		new DeviceInfoData(0x045e, 0x02e0, "Xbox Wireless Controller"),
		new DeviceInfoData(0x045e, 0x0b05, "Xbox Elite Wireless Controller"),
		new DeviceInfoData(0x0111, 0x1419, "SteelSeries Stratus XL"), 
		new DeviceInfoData(0x054c, 0x05c4, "PS4 Wireless Controller"),
		new DeviceInfoData(0x054c, 0x09cc, "PS4 Wireless Controller (v2)"),
		new DeviceInfoData(0x054c, 0x0ce6, "PS5 Wireless Controller"),
		new DeviceInfoData(0x05ac, 0x056a, "glap QXPGP001"),
		new DeviceInfoData(0x0483, 0x5750, "STMicroelectronics Lenovo GamePad"),
		new DeviceInfoData(0x1532, 0x0705, "Razer Razer Claire T1 Wired")
	};

	public class InputDeviceInfo {
		public int deviceId;
		public int vendorId;
		public int productId;
		public int controllerId;
		public String name;
		public String descriptor;

		InputDeviceInfo(int did, int vid, int pid, int cid, String inName, String inDescriptor)
		{
			deviceId = did;
			vendorId = vid;
			productId = pid;
			controllerId = cid;
			name = inName;
			descriptor = inDescriptor;
		}
	}

	public InputDeviceInfo AndroidThunkJava_GetInputDeviceInfo(int deviceId)
	{
		int[] deviceIds = InputDevice.getDeviceIds();
		for (int deviceIndex=0; deviceIndex < deviceIds.length; deviceIndex++)
		{
			InputDevice inputDevice = InputDevice.getDevice(deviceIds[deviceIndex]);
			if (inputDevice != null && inputDevice.getId() == deviceId)
			{
				int vendorId = 0;
				int productId = 0;
				int controllerNumber = 0;

				// requires 4.1 (Jellybean)
				String descriptor = ANDROID_BUILD_VERSION >= 16 ? inputDevice.getDescriptor() : Integer.toString(deviceId);

				// supported on 4.4 (KitKat) onward
				if (ANDROID_BUILD_VERSION >= 19)
				{
					vendorId = inputDevice.getVendorId();
					productId = inputDevice.getProductId();
					controllerNumber = inputDevice.getControllerNumber();

					// note: inputDevice.getName may not return a proper name so check vendor and product id first
					for (DeviceInfoData deviceInfo : DeviceInfoList)
					{
						if (deviceInfo.IsMatch(vendorId, productId))
						{
							return new InputDeviceInfo(deviceId, vendorId, productId, controllerNumber, deviceInfo.name, descriptor);
						}
					}
				}

				// use device name as fallback (may be generic like "Bluetooth HID" so not always useful)
				return new InputDeviceInfo(deviceId, vendorId, productId, controllerNumber, inputDevice.getName(), descriptor);
			}
		}
		return new InputDeviceInfo(deviceId, 0, 0, -1, "Unknown", "Unknown");
	}

	public void AndroidThunkJava_UseSurfaceViewWorkaround()
	{
		// We only need apply a change to the SurfaceHolder on the first call
		// Once bUseSurfaceView is true, it is never changed back
		if(bUseSurfaceView)
		{
			return;
		}

		bUseSurfaceView = true;
		Log.debug("[JAVA] Using SurfaceView sizing workaround for this device");

		if(DesiredHolderWidth > 0 && 
			DesiredHolderHeight > 0 &&
			MySurfaceView != null)
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					MySurfaceView.getHolder().setFixedSize(DesiredHolderWidth, DesiredHolderHeight);
				}
			});
		}
	}

	public boolean AndroidThunkJava_IsAllowedRemoteNotifications()
	{
		boolean bPluginEnabled = false;

		return bPluginEnabled && NotificationManagerCompat.from(getApplicationContext()).areNotificationsEnabled();
	}

	public void AndroidThunkJava_SetDesiredViewSize(int width, int height)
	{
		if (width == DesiredHolderWidth && height == DesiredHolderHeight)
		{
			return;
		}

		Log.debug("[JAVA] - SetDesiredViewSize width=" + width + " and height=" + height);
		DesiredHolderWidth = width;
		DesiredHolderHeight = height;

		if(bUseSurfaceView && MySurfaceView != null)
		{
			_activity.runOnUiThread(new Runnable()
			{
				@Override
				public void run()
				{
					MySurfaceView.getHolder().setFixedSize(DesiredHolderWidth, DesiredHolderHeight);
				}
			});
		}
	}

	public boolean AndroidThunkJava_IsGamepadAttached()
	{
		int[] deviceIds = InputDevice.getDeviceIds();
		for (int deviceIndex=0; deviceIndex < deviceIds.length; deviceIndex++)
		{
			InputDevice inputDevice = InputDevice.getDevice(deviceIds[deviceIndex]);
			// is it a joystick, dpad, or gamepad?
			if (((inputDevice.getSources() & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD)
                || ((inputDevice.getSources() & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK))
			{
				return true;
			}
		}

		return false;
	}

	public int[] AndroidThunkJava_GetSupportedNativeDisplayRefreshRates()
	{
		if(ANDROID_BUILD_VERSION >= 24)
		{
			WindowManager windowManager =  getWindowManager();
			Display display = windowManager.getDefaultDisplay();
			Display.Mode currentmode = display.getMode();
			Display.Mode[] modes = display.getSupportedModes();
			ArrayList<Integer> refreshlist = new ArrayList<Integer>();

			for (int i = 0; i < modes.length; i++)
			{
				if (modes[i].getPhysicalHeight() == currentmode.getPhysicalHeight() &&
					modes[i].getPhysicalWidth() == currentmode.getPhysicalWidth())
				{
					refreshlist.add((int)modes[i].getRefreshRate());
				}
			}
			if (refreshlist.size() == 0)
			{
				refreshlist.add(60);
			}
			int[] result = new int[refreshlist.size()];
			for (int i=0; i < result.length; i++)
			{
				result[i] = refreshlist.get(i).intValue();
			}
			return result;
		}
		else
		{
			int[] result = new int[1];
			result[0] = 60;
			return result;
		}
	}

	public boolean AndroidThunkJava_SetNativeDisplayRefreshRate(int RefreshRate)
	{
		if(ANDROID_BUILD_VERSION >= 24)
		{
			WindowManager windowManager =  getWindowManager();
			Display display = windowManager.getDefaultDisplay();
			Display.Mode currentmode = display.getMode();
			int currentmodeid = currentmode.getModeId();
			Display.Mode[] modes = display.getSupportedModes();

			for (int i = 0; i < modes.length; i++)
			{
				if (modes[i].getPhysicalHeight() == currentmode.getPhysicalHeight() &&
					modes[i].getPhysicalWidth() == currentmode.getPhysicalWidth() &&
					(int)modes[i].getRefreshRate() == RefreshRate)
				{
					final int modeid = modes[i].getModeId();
					if(currentmodeid != modeid)
					{
						_activity.runOnUiThread(new Runnable()
						{
							public void run()
							{
								Window w = getWindow();
								WindowManager.LayoutParams l = w.getAttributes();
								l.preferredDisplayModeId = modeid;
								w.setAttributes(l);
							}
						});
						Log.debug("Found mode " + modeid + " for native refresh rate "+RefreshRate);
					}
					return true;
				}
			}

			return false;
		}
		else
		{
			return (RefreshRate == 60);
		}
	}

	public int AndroidThunkJava_GetNativeDisplayRefreshRate()
	{
		if(ANDROID_BUILD_VERSION >= 24)
		{
			WindowManager windowManager =  getWindowManager();
			Display display = windowManager.getDefaultDisplay();
			Display.Mode currentmode = display.getMode();
			return (int)currentmode.getRefreshRate();
		}

		return 60;
	}

	public void AndroidThunkJava_EnableMotion(boolean Enable)
	{
		if(bAllowIMU != Enable) 
		{
			bAllowIMU = Enable;			
			if (Enable) 
			{
				if (accelerometer != null) 
				{
					sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
				}
				if (magnetometer != null) 
				{
					sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
				}
				if (gyroscope != null) 
				{
					sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME);
				}
			} 
			else 
			{
				sensorManager.unregisterListener(this);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static boolean isAirplaneModeOn(Context context)
	{
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
		{
			return Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) != 0;
		}
		return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
	}

	public String getConnectionType()
	{
		boolean bAirplaneMode = isAirplaneModeOn(getApplicationContext());

		ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

		boolean isConnected = (activeNetwork != null && activeNetwork.isAvailable() && activeNetwork.isConnectedOrConnecting());
		if (isConnected)
		{
			int connType = activeNetwork.getType();
			switch (connType)
			{
				case ConnectivityManager.TYPE_WIFI: return "WiFi";
				case ConnectivityManager.TYPE_BLUETOOTH: return bAirplaneMode ? "AirplaneMode" : "Bluetooth";
				case ConnectivityManager.TYPE_ETHERNET: return "Ethernet";
				case ConnectivityManager.TYPE_WIMAX: return bAirplaneMode ? "AirplaneMode" : "WiMAX";
			}
			return bAirplaneMode ? "AirplaneMode" : "Cell";
		}
		return bAirplaneMode ? "AirplaneMode" : "None";
    }

	public int AndroidThunkJava_GetNetworkConnectionType()
	{
		boolean bAirplaneMode = isAirplaneModeOn(getApplicationContext());

		ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

		boolean isConnected = (activeNetwork != null && activeNetwork.isAvailable() && activeNetwork.isConnectedOrConnecting());
		if (isConnected)
		{
			int connType = activeNetwork.getType();
			switch (connType)
			{
				case ConnectivityManager.TYPE_WIFI: return CONNECTION_TYPE_WIFI;
				case ConnectivityManager.TYPE_BLUETOOTH: return bAirplaneMode ? CONNECTION_TYPE_AIRPLANEMODE : CONNECTION_TYPE_BLUETOOTH;
				case ConnectivityManager.TYPE_ETHERNET: return CONNECTION_TYPE_ETHERNET;
				case ConnectivityManager.TYPE_WIMAX: return bAirplaneMode ? CONNECTION_TYPE_AIRPLANEMODE : CONNECTION_TYPE_WIMAX;
			}
			return bAirplaneMode ? CONNECTION_TYPE_AIRPLANEMODE : CONNECTION_TYPE_CELL;
		}
		return bAirplaneMode ? CONNECTION_TYPE_AIRPLANEMODE : CONNECTION_TYPE_NONE;
	}
	
	public boolean AndroidThunkJava_HasMetaDataKey(String key)
	{
		if (_bundle == null || key == null)
		{
			return false;
		}
		return _bundle.containsKey(key);
	}

	public boolean AndroidThunkJava_GetMetaDataBoolean(String key)
	{
		if (_bundle == null || key == null)
		{
			return false;
		}
		return _bundle.getBoolean(key);
	}

	public int AndroidThunkJava_GetMetaDataInt(String key)
	{
		if (key.equals("ue4.http.proxy.proxyPort"))
		{
			if (ANDROID_BUILD_VERSION >= 14)
			{
				String ProxyPort = System.getProperty("http.proxyPort");
				return ProxyPort == null ? -1 : Integer.parseInt(ProxyPort);
			}
			else
			{
				return android.net.Proxy.getPort(getApplicationContext());
			}
		}
		else
		if (key.equals("android.hardware.vulkan.version"))
		{
			return VulkanVersion;
		}
		else
		if (key.equals("android.hardware.vulkan.level"))
		{
			return VulkanLevel;
		}
		else
		if (key.equals("ue4.getUsedMemory"))
		{
			int ProcessMemory = 0;
			synchronized(_activity)
			{
				ProcessMemory = _activity.UsedMemory;
			}
			return ProcessMemory;
		}
		else
		if (key.equals("audiomanager.framesPerBuffer"))
		{
			AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			String framesPerBuffer = am.getProperty(AudioManager.PROPERTY_OUTPUT_FRAMES_PER_BUFFER);
			int framesPerBufferInt = framesPerBuffer == null ? 0 : Integer.parseInt(framesPerBuffer);
			if (framesPerBufferInt == 0) framesPerBufferInt = 256; // Use default
			Log.debug("[JAVA] audiomanager.framesPerBuffer = " + framesPerBufferInt);
			return framesPerBufferInt;
		}
		else
		if (key.equals("audiomanager.optimalSampleRate"))
		{
			AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			String sampleRateStr = am.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
			int sampleRateInt = sampleRateStr == null ? 0 : Integer.parseInt(sampleRateStr);
			if (sampleRateInt == 0) sampleRateInt = 44100; // Use a default value if property not found
			Log.debug("[JAVA] audiomanager.optimalSampleRate = " + sampleRateInt);
			return sampleRateInt;
		}
		if (_bundle == null || key == null)
		{
			return 0;
		}
		return _bundle.getInt(key);
	}

	public long AndroidThunkJava_GetMetaDataLong(String key)
	{
		if (key.equals("ue4.display.PresentationDeadlineNanos"))
		{
			if (android.os.Build.VERSION.SDK_INT >= 21)
			{
				WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
				android.view.Display display = windowManager.getDefaultDisplay();
				return display.getPresentationDeadlineNanos();
			}
			return -1;
		}
		else
		if (key.equals("ue4.display.AppVsyncOffsetNanos"))
		{
			if (android.os.Build.VERSION.SDK_INT >= 21)
			{
				WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
				android.view.Display display = windowManager.getDefaultDisplay();
				return display.getAppVsyncOffsetNanos();
			}
			return -1;
		}
		return 0;
	}

	public float AndroidThunkJava_GetMetaDataFloat(String key)
	{
		if (key.equals("ue4.display.getRefreshRate"))
		{
			WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
			android.view.Display display = windowManager.getDefaultDisplay();
			float rate = display.getRefreshRate();
			// make sure it is sane.. some drivers returned crazy values
			return rate < 15.0f ? 60.0f : rate;
		}
		return 0.0f;
	}

	public String AndroidThunkJava_GetMetaDataString(String key)
	{
		if (key.startsWith("getprop:"))
		{
			return getProp(key.substring(8));
		}
		else
		if (key.equals("ue4.http.proxy.proxyHost"))
		{
			if (ANDROID_BUILD_VERSION >= 14)
			{
				return System.getProperty("http.proxyHost");
			}
			else
			{
				return android.net.Proxy.getHost(getApplicationContext());
			}
		}
		else
		if (key.equals("ue4.displaymetrics.dpi"))
		{
			DisplayMetrics metrics = new DisplayMetrics();
			if (android.os.Build.VERSION.SDK_INT >= 17)
			{
				getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
			} else {
				// note: not available so get what we can
				getWindowManager().getDefaultDisplay().getMetrics(metrics);
			}

			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator('.');
			DecimalFormat decimalFormat = new DecimalFormat("###.##", symbols);

			String screenDPI = decimalFormat.format(metrics.xdpi) + "," + decimalFormat.format(metrics.ydpi) + "," + decimalFormat.format(metrics.densityDpi);
			return screenDPI;
		}
		else
		if (_bundle == null || key == null)
		{
			return null;
		}
		return _bundle.getString(key);
	}

	public boolean AndroidThunkJava_HasIntentExtrasKey(String key)
	{
		if (_extrasBundle == null || key == null)
		{
			return false;
		}
		return _extrasBundle.containsKey(key);
	}

	public boolean AndroidThunkJava_GetIntentExtrasBoolean(String key)
	{
		if (_extrasBundle == null || key == null)
		{
			return false;
		}
		return _extrasBundle.getBoolean(key);
	}

	public int AndroidThunkJava_GetIntentExtrasInt(String key)
	{
		if (_extrasBundle == null || key == null)
		{
			return 0;
		}
		return _extrasBundle.getInt(key);
	}

	public String AndroidThunkJava_GetIntentExtrasString(String key)
	{
		if (_extrasBundle == null || key == null)
		{
			return null;
		}
		return _extrasBundle.getString(key);
	}

	public void AndroidThunkJava_SetSustainedPerformanceMode(final boolean bEnable)
	{
		if (ANDROID_BUILD_VERSION >= 24)
		{
			Log.debug("==================================> SetSustainedPerformanceMode:"+bEnable);
			_activity.runOnUiThread(new Runnable()
			{
				public void run()
				{
					try
					{
						android.view.Window ActivityWindow = _activity.getWindow();
						Method m = android.view.Window.class.getMethod("setSustainedPerformanceMode",Boolean.TYPE);
						m.invoke(ActivityWindow, bEnable);
					}
					catch (Exception e)
					{
						Log.debug("SetSustainedPerformanceMode: failed "+ e.getMessage());
					}
				}
			});
		}
		else
		{
			Log.debug("==================================> API<24, cannot use SetSustainedPerformanceMode");
		}
	}

	//console input text input class with history - custom EditText
	public class ConsoleKeyboardInput extends EditText
	{
		private android.widget.ImageButton historyButton;
		private ArrayList<String> historyList;

		public ConsoleKeyboardInput(Context context, AttributeSet attrs, int defStyle)
		{
			super(context, attrs, defStyle);
			init(context);
		}

		public ConsoleKeyboardInput(Context context, AttributeSet attrs)
		{
			super(context, attrs);
			init(context);
		}

		public ConsoleKeyboardInput(Context context)
		{
			super(context);
			init(context);
		}

		private void init(Context context)
		{
			historyList = new ArrayList<String>();
			historyButton = new android.widget.ImageButton(context);
			historyButton.setImageResource(android.R.drawable.ic_menu_revert);
			historyButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if (historyList.size() > 0) {
						final String[] history = historyList.toArray(new String[historyList.size()]);

						AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
						builder.setTitle("History");
						builder.setCancelable(true);
						builder.setItems(history, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								String selected = historyList.get(which);
								consoleInputBox.removeHistory(selected);
								consoleInputBox.addHistory(selected);
								consoleInputBox.setText(selected);
								dialog.dismiss();
							}
						});
						builder.show();
					}
				}
			});
			historyButton.setEnabled(false);
		}
		
		private android.widget.ImageButton getButton()
		{
			return historyButton;
		}

		public void setHistoryList(ArrayList<String> inHistoryList)
		{
			historyList = inHistoryList;
		}

		public void removeHistory(String value)
		{
			int index = historyList.indexOf(value);
			if (index >= 0)
			{
				historyList.remove(index);
			}
			historyButton.setEnabled(historyList.size() > 0);
		}

		public void addHistory(String value)
		{
			historyList.add(0, value);
			historyButton.setEnabled(historyList.size() > 0);
		}

		public void setHistoryEnd()
		{
			historyButton.setEnabled(historyList.size() > 0);
		}
	}
	
	//virtual keyboard input class - custom EditText
	public class VirtualKeyboardInput extends EditText 
	{
		public VirtualKeyboardInput(Context context, AttributeSet attrs, int defStyle) 
		{
			super(context, attrs, defStyle);
	        init();
		}

		public VirtualKeyboardInput(Context context, AttributeSet attrs) 
		{
			super(context, attrs);
	        init();
		}

		public VirtualKeyboardInput(Context context) 
		{
			super(context);
	        init();
		}

		private void init() 
		{
			if (emojiExcludeFilter == null)
			{
				emojiExcludeFilter = new EmojiExcludeFilter();
			}
			//setFilters(new InputFilter[]{emojiExcludeFilter});
		}

		@Override
		public void setFilters(InputFilter[] filters) 
		{
			if (filters.length != 0 && emojiExcludeFilter != null) 
			{ //if length == 0 it will here return when init() is called
				boolean add = true;
				for (InputFilter inputFilter : filters) 
				{
					if (inputFilter == emojiExcludeFilter) 
					{
						add = false;
						break;
					}
				}
				if (add)
				{
					filters = Arrays.copyOf(filters, filters.length + 1);
					filters[filters.length - 1] = emojiExcludeFilter;
				}
			}
			super.setFilters(filters);
		}
		    
		private EmojiExcludeFilter emojiExcludeFilter;

	    private class EmojiExcludeFilter implements InputFilter 
	    {
	        @Override
	        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
	            for (int i = start; i < end; i++) {
	                int type = Character.getType(source.charAt(i));
	                if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
	                    return "";
	                }
	            }
	            return null;
	        }
	    }

		//Override BACK key to hide the virtual keyboard
		@Override 
		public boolean onKeyPreIme(int keyCode, KeyEvent event) 
		{
		    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) 
			{
		    	AndroidThunkJava_HideVirtualKeyboardInput();
				nativeVirtualKeyboardSendKey(KeyEvent.KEYCODE_BACK);
		    }
		    return super.dispatchKeyEvent(event);
		}

		// listen for cursor position changes &  send message to the UMG widget
		@Override   
		protected void onSelectionChanged(int selStart, int selEnd) 
		{
			nativeVirtualKeyboardSendSelection(selStart, selEnd);
		}

		//extend associated InputConnection to handle special keys 
		@Override
		public InputConnection onCreateInputConnection(EditorInfo outAttrs) 
		{
			return new VirtualKeyboardInputConnection(super.onCreateInputConnection(outAttrs), true, this);
		}

		private class VirtualKeyboardInputConnection extends InputConnectionWrapper 
		{
			VirtualKeyboardInput owner;
			public VirtualKeyboardInputConnection(InputConnection target, boolean mutable, VirtualKeyboardInput editText) 
			{
				super(target, mutable);
				owner = editText;
			}

			private void replaceSubstring(String newString)
			{
				StringBuffer text = new StringBuffer(owner.getText().toString());
				int selStart, selEnd;
 
				int a = owner.getSelectionStart();
				int b = owner.getSelectionEnd();
 
				selStart = Math.min(a, b);
				selEnd = Math.max(a, b);
				//Log.debug("VK: replaceSubstring selStart=" + selStart + " selEnd="+selEnd + " text="+text);

				if (selStart != selEnd) 
				{
					//replace
					text.replace(selStart, selEnd, newString);
				} 
				else if(newString.length() > 0)
				{ 
					//insert
					text.insert(selStart, newString);
				}
				else if(selStart > 0) 
				{
					// selection start and end are the same, but in the middle of the string
					// this means we want a single "delete character to left of selection" (backspace)

					// using BreakIterator to ensure we capture proper emoji / Unicode grapheme boundaries
					BreakIterator finder = BreakIterator.getCharacterInstance();
					finder.setText(owner.getText().toString());

					selStart = finder.preceding(selStart);
					if (selStart == BreakIterator.DONE)
					{
						selStart = 0;
					}
					text.replace(selStart, selEnd, "");
				}

				if(newString.length() == 0)
				{
					//#jira UE-48948 Crash when pressing backspace on empty line 
					selStart--;
				}
				//#jira UE-49120 Virtual keyboard number pad "kicks" user back to regular keyboard
				owner.getText().clear();
				owner.append(text.toString());
				owner.setSelection(selStart + 1);
			}


			//implement virtual keyboard's NUMERIC, BACKSPACE and ENTER keys
			@Override
			public boolean sendKeyEvent(KeyEvent event) 
			{
				////Log.debug("VK: sendKeyEvent " + event.getKeyCode() );
				if (event.getAction() == KeyEvent.ACTION_DOWN )
				{ 
					if(event.getKeyCode() >= KeyEvent.KEYCODE_0 && event.getKeyCode() <= KeyEvent.KEYCODE_9)
					{
						char numChar = (char)('0' + (event.getKeyCode() - KeyEvent.KEYCODE_0));
						replaceSubstring(String.valueOf(numChar));
					}
					else if(event.getKeyCode() >= KeyEvent.KEYCODE_NUMPAD_0 && event.getKeyCode() <= KeyEvent.KEYCODE_NUMPAD_9)
					{
						char numChar = (char)('0' + (event.getKeyCode() - KeyEvent.KEYCODE_NUMPAD_0));
						replaceSubstring(String.valueOf(numChar));
					}
					else if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) 
					{
						//delete selected text / previous character
						replaceSubstring("");
					}
					else if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
					{

						if (0 != (getInputType() & InputType.TYPE_TEXT_FLAG_MULTI_LINE))
						{
							//add new line
							replaceSubstring("\n");
						}
						else
						{
							AndroidThunkJava_HideVirtualKeyboardInput();
							nativeVirtualKeyboardSendKey(KeyEvent.KEYCODE_ENTER);
						}
					}
				}
				return true;
			}

			//in latest Android, deleteSurroundingText(1, 0) will be called for BACKSPACE
			@Override
			public boolean deleteSurroundingText(int beforeLength, int afterLength) 
			{       
				////Log.debug("VK: deleteSurroundingText");
				if (beforeLength == 1 && afterLength == 0) 
				{
					// backspace
					return sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
						&& sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
				}

				return super.deleteSurroundingText(beforeLength, afterLength);
			}

		}
	}

	//create the virtual keyboard input 
	private void createVirtualKeyboardInput()
	{
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		newVirtualKeyboardInput = new VirtualKeyboardInput(this);
		newVirtualKeyboardInput.setSingleLine(false);
		newVirtualKeyboardInput.setBackgroundColor(Color.WHITE);
		newVirtualKeyboardInput.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		newVirtualKeyboardInput.setVisibility(View.GONE);
		if (ANDROID_BUILD_VERSION < 11)
		{
			newVirtualKeyboardInput.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
		}
		else
		{
			newVirtualKeyboardInput.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI | EditorInfo.IME_FLAG_NO_FULLSCREEN);
		}

		newVirtualKeyboardInput.setOnEditorActionListener(new OnEditorActionListener() 
		{
			@Override
			public boolean onEditorAction(TextView view, int actionId, KeyEvent event) 
			{
				////Log.debug("VK: onEditorAction");
				int result = actionId & EditorInfo.IME_MASK_ACTION;
				switch(result) 
				{
				case EditorInfo.IME_ACTION_DONE:
					AndroidThunkJava_HideVirtualKeyboardInput();
					nativeVirtualKeyboardSendKey(KeyEvent.KEYCODE_ENTER);
	                return true;
				}
	            return false;
		}
		});

		newVirtualKeyboardInput.addTextChangedListener(new TextWatcher() 
		{
			@Override
			public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) 
			{
			}

			@Override
			public void afterTextChanged(Editable s) 
			{
			}

			@Override
			public void onTextChanged(CharSequence charSequence, int start, int before, int count) 
			{
				//send to the associated Slate control
				//Log.debug("VK onTextChanged " + charSequence);

				//#jira UE-49143 Inconsistent virtual keyboard behavior tapping between controls
				if(newVirtualKeyboardInput.getY() > 0 || bUsesVrKeyboard)
				{
					//try to avoid "false empty string" events
					//delay the "set empty string" event and wait for a second call
					if(charSequence.length() == 0)
					{
						virtualKeyboardHandler.postDelayed(new Runnable()
						{
							public void run()
							{
								String message = newVirtualKeyboardInput.getText().toString();
								nativeVirtualKeyboardChanged(message);
							}
						}, 100);
					}
					else
					{
						virtualKeyboardHandler.postDelayed(new Runnable()
						{
							public void run()
							{
								String message = newVirtualKeyboardInput.getText().toString();
								//#jira UE-50645 Carriage returns can be pasted into single line UMG fields on Android
								//oddly enough, we have to use events/filters to control the EditText's copy/paste behaviour
								if(newVirtualKeyboardInput.getMaxLines() == 1 && message.contains("\n"))
								{
									message = message.replaceAll("\n" , " ");
									newVirtualKeyboardInput.setText(message);
						
								}
								nativeVirtualKeyboardChanged(message);
							}
						}, 100);
					}
				}
				downgradeEasyCorrectionSpans();
			}

			/**
			 * Downgrades to simple suggestions all the easy correction spans that are not a spell check
			 * span.
			 */
			private void downgradeEasyCorrectionSpans() 
			{
				CharSequence text = newVirtualKeyboardInput.getText();
				if(android.os.Build.VERSION.SDK_INT >= 14) 
				{
					if (text instanceof android.text.Spannable) 
					{
						android.text.Spannable spannable = (android.text.Spannable) text;
						android.text.style.SuggestionSpan[] suggestionSpans = spannable.getSpans(0, spannable.length(), android.text.style.SuggestionSpan.class);
						for (int i = 0; i < suggestionSpans.length; i++) 
						{
							int flags = suggestionSpans[i].getFlags();
							if ((flags & android.text.style.SuggestionSpan.FLAG_EASY_CORRECT) != 0 && (flags & android.text.style.SuggestionSpan.FLAG_MISSPELLED) == 0) 
							{
								flags &= ~android.text.style.SuggestionSpan.FLAG_EASY_CORRECT;
								suggestionSpans[i].setFlags(flags);
							}
						}
					}
				}
			}
		});
		
		virtualKeyboardLayout.addView (newVirtualKeyboardInput);

		virtualKeyboardHandler = new Handler(android.os.Looper.getMainLooper());

	}

	protected List<View> GetExtraIgnoreViews()
	{
		return null;
	}

	//check if the new virtual keyboard input has received a MOUSE_DOWN event
	// or the keyboard animation is playing
	public boolean AndroidThunkJava_VirtualInputIgnoreClick(int x, int y) 
	{
		View view = getCurrentFocus();
		if (view == newVirtualKeyboardInput) 
		{
			Rect r = new Rect();
			view.getGlobalVisibleRect(r);
			if (r.contains(x, y) || newVirtualKeyboardInput.getY() < 0) 
			{
				//Log.debug("VK: AndroidThunkJava_VirtualInputIgnoreClick true");
				return true;
			}
		}
		else
		{
			List<View> ExtraIgnoreViews = GetExtraIgnoreViews();
			if (ExtraIgnoreViews != null)
			{
				for (int i = 0; i < ExtraIgnoreViews.size(); i++)
				{
					Rect r = new Rect();
					ExtraIgnoreViews.get(i).getGlobalVisibleRect(r);
					if (r.contains(x, y))
					{
						//Log.debug("Webview: AndroidThunkJava_VirtualInputIgnoreClick true");
						return true;
					}
				}
			}
		}

		//Log.debug("VK: AndroidThunkJava_VirtualInputIgnoreClick false");
		return false;
	}
	public boolean AndroidThunkJava_LaunchPackage(String packageName, String extraKey, String extraValue)
	{
		Intent intent;
		String intentAction = "";
		String intentComponent = "";

		int intentActionIndex = packageName.indexOf(":");
		if (intentActionIndex >= 0)
		{
			intentAction = packageName.substring(intentActionIndex + 1);
			packageName = packageName.substring(0, intentActionIndex);

			intentActionIndex = intentAction.indexOf(":");
			if (intentActionIndex >= 0)
			{
				intentComponent = intentAction.substring(intentActionIndex + 1);
				intentAction = intentAction.substring(0, intentActionIndex);
			}
		}

		if (!AndroidThunkJava_IsPackageInstalled(packageName))
		{
			return false;
		}

		if (intentAction.equals(""))
		{
			intent = getPackageManager().getLaunchIntentForPackage(packageName);
			if (intent == null)
			{
				return false;
			}
		}
		else
		{
			intent = new Intent(intentAction);
			if (intent == null)
			{
				return false;
			}
			intent.setPackage(packageName);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}

		if (!extraKey.equals(""))
		{
			intent.putExtra(extraKey, extraValue);
		}

		if (!intentComponent.equals(""))
		{
			intent.setComponent(new android.content.ComponentName(packageName, intentComponent));
		}

		if (intent.resolveActivity(getPackageManager()) != null)
		{
			startActivity(intent);
			AndroidThunkJava_ForceQuit();
			return true;
		}

		return false;
	}

	public boolean AndroidThunkJava_SendBroadcast(String packageName, String extraKey, String extraValue, boolean bExit)
	{
		Intent intent;
		String intentAction = "";
		String intentComponent = "";

		int intentActionIndex = packageName.indexOf(":");
		if (intentActionIndex >= 0)
		{
			intentAction = packageName.substring(intentActionIndex + 1);
			packageName = packageName.substring(0, intentActionIndex);

			intentActionIndex = intentAction.indexOf(":");
			if (intentActionIndex >= 0)
			{
				intentComponent = intentAction.substring(intentActionIndex + 1);
				intentAction = intentAction.substring(0, intentActionIndex);
			}
		}

		if (!AndroidThunkJava_IsPackageInstalled(packageName))
		{
			return false;
		}

		if (intentAction.equals(""))
		{
			intent = getPackageManager().getLaunchIntentForPackage(packageName);
			if (intent == null)
			{
				return false;
			}
		}
		else
		{
			intent = new Intent(intentAction);
			if (intent == null)
			{
				return false;
			}
			intent.setPackage(packageName);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}

		if (!extraKey.equals(""))
		{
			intent.putExtra(extraKey, extraValue);
		}

		if (!intentComponent.equals(""))
		{
			intent.setComponent(new android.content.ComponentName(packageName, intentComponent));
		}

		getApplicationContext().sendBroadcast(intent);

		if (bExit)
		{
			AndroidThunkJava_ForceQuit();
		}
		
		return true;
	}

	private void RestartApplication(String RestartExtra)
	{
		Context context = getApplicationContext();
	
		// get the launch intent
		PackageManager packageManager = context.getPackageManager();
		Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());

		// make an "restart intent", to be used to re-launch an application's task in its base state
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		intent.putExtra("RestartExtra", RestartExtra);
		context.startActivity(intent);

		// kill the current application instance. Undefined behaviour after this!
		Runtime.getRuntime().exit(0); 
	}

	public void AndroidThunkJava_RestartApplication(final String RestartExtra) 
	{
	    Runnable restartRunnableUIThread = new Runnable()
		{
			@Override
			public void run()
			{
				RestartApplication(RestartExtra);
			}
		};
		Log.debug("app restart : " + RestartExtra);

		runOnUiThread(restartRunnableUIThread);

		// wait for exit.
		while(true)
		{
			try 
			{
				Thread.sleep(Long.MAX_VALUE); 
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void AndroidThunkJava_ClipboardCopy(String text) 
	{
		ClipData clip = ClipData.newPlainText("Copied Text", text);
		clipboardManager.setPrimaryClip(clip);
	}

	public String AndroidThunkJava_ClipboardPaste() 
	{
		if(clipboardManager.hasPrimaryClip()) 
		{
			ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
			return item.getText().toString();
		} 
		return "";
	}

	public int AndroidThunkJava_GetDeviceOrientation() 
	{
		return getWindowManager().getDefaultDisplay().getRotation();
	}

	@SuppressWarnings("deprecation")
	public boolean AndroidThunkJava_CookieManager_SetCookie(String Url, String Value)
	{
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
		{
			CookieManager cookieManager = CookieManager.getInstance();
			if (cookieManager != null)
			{
				cookieManager.setAcceptCookie(true);
				cookieManager.setCookie(Url, Value);  // could use callback for API 21+
				cookieManager.flush();
				return true;
			}
		}
		else
		{
			Context context = getApplicationContext();
			CookieSyncManager syncManager = CookieSyncManager.createInstance(context);
			syncManager.sync();

			CookieManager cookieManager = CookieManager.getInstance();
			if (cookieManager != null)
			{
				cookieManager.setAcceptCookie(true);

				cookieManager.setCookie(Url, Value);
				syncManager.sync();
				return true;
			}
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	public String AndroidThunkJava_CookieManager_GetCookies(String Url)
	{
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP)
		{
			Context context = getApplicationContext();
			CookieSyncManager syncManager = CookieSyncManager.createInstance(context);
			syncManager.sync();
		}

		CookieManager cookieManager = CookieManager.getInstance();
		if (cookieManager != null)
		{
			cookieManager.setAcceptCookie(true);
			return cookieManager.getCookie(Url);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public boolean AndroidThunkJava_CookieManager_RemoveCookies(String Url)
	{
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP)
		{
			Context context = getApplicationContext();
			CookieSyncManager syncManager = CookieSyncManager.createInstance(context);
			syncManager.sync();

			CookieManager cookieManager = CookieManager.getInstance();
			if (cookieManager != null)
			{
				cookieManager.setAcceptCookie(true);
				String cookies = cookieManager.getCookie(Url);
				if (cookies == null)
				{
					return false;
				}

				cookieManager.setCookie(Url, "expires=Sat, 1 Jan 2000 00:00:01 UTC;");
				cookieManager.removeExpiredCookie();
				syncManager.sync();
				return true;
			}
			return false;
		}

		CookieManager cookieManager = CookieManager.getInstance();
		if (cookieManager != null)
		{
			cookieManager.setAcceptCookie(true);
			String cookies = cookieManager.getCookie(Url);
			if (cookies == null)
			{
				return false;
			}

			cookieManager.setCookie(Url, "expires=Sat, 1 Jan 2000 00:00:01 UTC;"); // could use callback for API 21+
			cookieManager.flush();
			return true;
		}
		return false;
	}

	public native int nativeGetCPUFamily();
	public native boolean nativeSupportsNEON();
	public native void nativeSetAffinityInfo(boolean bEnableAffinity, int bigCoreMask, int littleCoreMask);
	public native void nativeSetConfigRulesVariables(String[] KeyValuePairs);

	public native boolean nativeIsShippingBuild();
	public native void nativeSetAndroidStartupState(boolean bDebuggerAttached);
	public native void nativeSetGlobalActivity(boolean bUseExternalFilesDir, boolean bPublicLogFiles, String internalFilePath, String externalFilePath, boolean bOBBInAPK, String APKPath);
	public native void nativeSetObbFilePaths(String OBBMainFilePath, String OBBPatchFilePath, String OBBOverflow1FilePath, String OBBOverflow2FilePath);
	public native void nativeSetWindowInfo(boolean bIsPortrait, int DepthBufferPreference);
	public native void nativeSetObbInfo(String ProjectName, String PackageName, int Version, int PatchVersion, String AppType);
	public native void nativeSetAndroidVersionInformation( String AndroidVersion, int TargetSDK, String PhoneMake, String PhoneModel, String PhoneBuildNumber, String OSLanguage );

	public native void nativeSetSurfaceViewInfo(int width, int height);
	public native void nativeSetSafezoneInfo(boolean bIsPortrait, float left, float top, float right, float bottom);

	public native void nativeConsoleCommand(String commandString);
	public native void nativeVirtualKeyboardChanged(String contents);
	public native void nativeVirtualKeyboardResult(boolean update, String contents);
	public native void nativeVirtualKeyboardSendKey(int keyCode);
	public native void nativeVirtualKeyboardSendTextSelection(String contents, int selStart, int selEnd);
	public native void nativeVirtualKeyboardSendSelection(int selStart, int selEnd);

	public native void nativeInitHMDs();

	public native void nativeResumeMainInit();

	public native void nativeOnActivityResult(GameActivity activity, int requestCode, int resultCode, Intent data);

	public native void nativeGoogleClientConnectCompleted(boolean bSuccess, String accessToken);

	public native void nativeVirtualKeyboardShown(int left, int top, int right, int bottom);
	public native void nativeVirtualKeyboardVisible(boolean bShown);

	public native void nativeOnConfigurationChanged(boolean bPortrait);
		
	public native void nativeOnInitialDownloadStarted();
	public native void nativeOnInitialDownloadCompleted();
	
	public native void nativeOnThermalStatusChangedListener(int status);
	public native void nativeOnTrimMemory(int MemoryTrimValue);
	public native void nativeSetMemoryAdvisorState(int State, int EstimateAvailableMB, int OOMScore);

	static
	{
		System.loadLibrary("UE4");
		try
		{
			System.loadLibrary("vrapi");
		}
		catch (java.lang.UnsatisfiedLinkError e)
		{
			Log.debug(e.toString());
			Log.debug("vrapi library not loaded and may be required for Oculus VR.");
		}
		try
		{
			System.loadLibrary("OVRPlugin");
		}
		catch (java.lang.UnsatisfiedLinkError e)
		{
			Log.debug(e.toString());
			Log.debug("OVRPlugin library not loaded and may be required for Oculus VR.");
		}

		System.loadLibrary("c++_shared");
	}

	public native void nativeHandleSensorEvents(float[] tilt, float[] rotation_rate, float[] gravity, float[] acceleration);

	private static ClipboardManager clipboardManager;

}
