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
