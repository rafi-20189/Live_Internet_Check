
![Logo](https://i.ibb.co/pdW0GSx/Orange-Professional-Smart-Spark-Creative-Agency-Logo-512-512-px.png)

## Features

- Live internet check❤
- Show custom alert dialog💖
- Offline Dinosaur Game😍


## Getting Started

### Step 1.
- First add permission (AndroidManifest)
```bash

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

```



### Step 2. 
- Add the dependency for using Lottie (build.gradle)
```bash
   
    implementation "com.airbnb.android:lottie:6.0.1"
```

### Step 3. 
- [Download a no internet Lottie animation] (https://lottiefiles.com/) json file named "no_internet_anim" and paste it inside res >> raw


### Step 4. 
- Create a Java class named "NetworkChangeReceiver" then paste the following codes
```bash
   public class NetworkChangeReceiver extends BroadcastReceiver {

    private NetworkChangeListener listener;

    public NetworkChangeReceiver(NetworkChangeListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            boolean isConnected = isNetworkConnected(context);
            listener.onNetworkChanged(isConnected);
        }
    }

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        }
        return false;
    }

    public interface NetworkChangeListener {
        void onNetworkChanged(boolean isConnected);
    }
}
    
```

    
### Step 5. 
- Create custom alert dialog xml file named "no_internet_dialog" inside res >> layout folder then paste the following codes
```bash

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="450dp"
        android:layout_marginStart="12dp"
        android:layout_marginEnd="12dp"
        app:cardCornerRadius="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:id="@+id/playButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="32dp"
                android:layout_marginEnd="32dp"
                android:layout_marginBottom="24dp"
                android:background="@drawable/button_bg"
                android:backgroundTint="#1AB8FF"
                android:clickable="true"
                android:fontFamily="@font/roboto_bold"
                android:foreground="?attr/selectableItemBackground"
                android:gravity="center"
                android:letterSpacing="0.05"
                android:paddingVertical="6dp"
                android:text="Play Game"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.5"
                app:layout_constraintStart_toStartOf="parent" />

            <TextView
                android:id="@+id/textView4"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="16dp"
                android:layout_marginTop="12dp"
                android:layout_marginEnd="16dp"
                android:letterSpacing="0.1"
                android:text="check internet and try again"
                android:textColor="#1C1C1C"
                android:textSize="15sp"
                android:textStyle="bold"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView2" />

            <com.airbnb.lottie.LottieAnimationView
                android:id="@+id/internetAnim"
                style="?android:attr/progressBarStyle"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:visibility="visible"
                app:layout_constraintBottom_toTopOf="@+id/textView2"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.5"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.26999998"
                app:layout_constraintVertical_chainStyle="packed"
                app:lottie_autoPlay="true"
                app:lottie_loop="true"
                app:lottie_rawRes="@raw/no_internet_anim" />

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="16dp"
                android:layout_marginTop="24dp"
                android:layout_marginEnd="16dp"
                android:letterSpacing="0.1"
                android:text="Internet Not Available"
                android:textColor="#292929"
                android:textSize="22sp"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.5"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/internetAnim" />

        </androidx.constraintlayout.widget.ConstraintLayout>
    </androidx.cardview.widget.CardView>
</androidx.constraintlayout.widget.ConstraintLayout>
    
```

    




