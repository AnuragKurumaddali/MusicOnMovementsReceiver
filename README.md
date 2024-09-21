**MusicOnMovementsReceiver**

**Overview**<br/>
`MusicOnMovementsReceiver` is an Android application designed to receive Open Sound Control (OSC) messages containing gesture data (such as frequency and amplitude values). The app interprets these values and provides a visual update on the screen, along with playing a sound based on the received amplitude.

**How the App Works**<br/>

The app listens for incoming OSC messages on a specified port (default is port 8000). When it receives messages containing gesture data (frequency and amplitude values), the app updates the UI with the corresponding values and plays a sound to reflect the gesture's amplitude.

Key components:

**1. MainActivity:**

- Displays the current status of message reception.
- Shows the received frequency and amplitude values in real-time.
- Starts and stops the OSC message listener (`OscMessageReceiver`).

**2. OscMessageReceiver:**

- Listens for OSC messages sent to the specified port.
- Parses incoming messages to extract gesture data.
- Updates the UI with the received frequency and amplitude values.
- Plays a sound using the `SoundPool` based on the received amplitude.

**How the OSC Messages Are Received**<br/>

The app uses the `OSCPortIn` class from the `JavaOSC` library to receive OSC messages. It listens for messages sent to the address `/gesture/coordinates`. Each message contains two values representing the frequency (x-coordinate) and amplitude (y-coordinate) of the gesture.

**OSC Message Flow:** <br/>

**1. Listening for Messages:** The `OscMessageReceiver` initializes an OSC listener on the specified port (default is 8000).<br/>

**2. Handling Messages:** When a message is received at the `/gesture/coordinates` address with two arguments (frequency and amplitude):<br/>
  - The app updates the `statusTextView`, `frequencyTextView`, and `amplitudeTextView` with the respective values.<br/>
  - The app plays a sound using `SoundPool`, with the volume adjusted based on the received amplitude.<br/>

**3. UI Update:** The main activity is updated in real-time to reflect the incoming data, giving users feedback on the received gestures.

**Dependency:** <br/>
- For Sending OSC Messages Use the dependent Server App : https://github.com/AnuragKurumaddali/MusicOnMovement.git

**References**
- **JavaOSC:**
  * https://github.com/hoijui/JavaOSC/
  * https://github.com/sparks/javaosc/

######################################################################################################################################################################################################################<br/>

### Prerequisites<br/>
Before you begin, make sure you have the following:<br/>

**1. Android Studio:** Installed and updated to the latest version.<br/>
**2. Git:** Installed on your system to clone the repository.<br/>
**3. A physical Android device:** Required for testing, as the app uses the camera and device sensors.<br/>
**4. USB Debugging Enabled:** On your Android device.<br/>

## Step-by-Step Guide<br/>

**Step 1: Clone the Repository**<br/>

First, open a terminal window and run the following command to clone the repository using Git:
```bash
https://github.com/AnuragKurumaddali/MusicOnMovementsReceiver.git
```
**Step 2: Open the Project in Android Studio**

1. **Launch Android Studio**.
2. From the welcome screen, select **Open an Existing Project**.
3. Navigate to the directory where you cloned the project, and click on the **MusicOnMovementsReceiver** folder.
4. Click **OK** to load the project.
5. Android Studio will take some time to load the project, sync dependencies, and index the code.

**Step 3: Sync Project with Gradle Files**
1. After the project is loaded, Android Studio will automatically attempt to sync the Gradle files.
2. If the sync does not start automatically, go to the **File** menu and select **Sync Project with Gradle Files**.
3. Make sure the **Gradle Build** is successful before proceeding.

If any dependencies are missing, you will see an error message. Android Studio might prompt you to install additional tools or SDK components (such as the Android SDK). Follow the prompts to install them.

**Step 4: Build the App**<br/>

Once all dependencies are synced and Gradle build is successful, you can build the app:

1. Go to the **Build** menu in Android Studio.
2. Select **Build Bundle(s) / APK(s) > Build APK(s)**.
3. Wait for the build process to complete.
Alternatively, you can click the **Run** button (green play icon) in the toolbar, which will build and run the app on a connected device.

**Step 5: Connect a Physical Android Device**<br/>

1. Connect your Android device to your computer via USB.
2. Ensure that USB Debugging is enabled on your device. You can enable **USB Debugging** by going to **Settings > Developer Options > USB Debugging**.
    - If Developer Options are not visible, go to **Settings > About Phone** and tap the **Build Number** 7 times to enable it.
4. When the device is connected, Android Studio will detect it.

**Step 6: Run the App on the Device**<br/>
1. Select the connected Android device from the device dropdown in Android Studio.
2. Click the **Run** button (green play icon) in the toolbar.
3. Android Studio will install the app on the connected device and launch it.


**Troubleshooting**
- **Gradle Sync Issues:** If you encounter problems with Gradle dependencies, try clearing the Gradle cache or invalidating Android Studio caches by going to **File > Invalidate Caches / Restart**.
- **Device Not Detected:** If your device is not recognized by Android Studio, ensure that **USB Debugging** is enabled, and your USB cable and port are functioning properly.
- **Permission Denials:** If the app crashes due to permission issues, verify that the required permissions are included in the manifest and that the user has granted them at runtime.
