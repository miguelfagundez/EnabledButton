# EnabledButton
Enabled/Disable button using EditText and addTextChangedListener in Kotlin


## Include EditTexts and Buttons into activity_main.xml as needed.

```
    <!-- Username -->
    <EditText
        android:id="@+id/editTextTop"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        android:layout_marginTop="50dp"
        android:hint="Username"
        android:paddingStart="10dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

    <!-- Password -->
    <EditText
        android:id="@+id/editTextBottom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        android:layout_marginTop="50dp"
        android:hint="Password"
        android:paddingStart="10dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/editTextTop"/>

    <!-- Enable/Disable button -->
    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Send Data"
        android:layout_marginTop="50dp"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        android:enabled="false"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/editTextBottom"/>
```

## MainActivity.java

Define views

```
    // Views
    lateinit var editTextUsername : EditText
    lateinit var editTextPassword : EditText
    lateinit var button : Button
```

Define boolean variables (For knowing if Username & Password are empty or not)

```
    // Variables
    var usernameEnabled : Boolean = false
    var passwordEnabled : Boolean = false
```

Define .findViewById using each view

```
    editTextUsername = findViewById(R.id.editTextTop)
    editTextPassword = findViewById(R.id.editTextBottom)
    button = findViewById(R.id.button)
```

Finally, I define a listener in each EditText (Define any condition that you like)

```
    editTextUsername.addTextChangedListener {username ->
            var text : String? = username?.toString()?.trim()
            text?.let {
                usernameEnabled = !it.isNullOrEmpty()
                button.isEnabled = usernameEnabled && passwordEnabled
            }
        }
        
    editTextPassword.addTextChangedListener {password ->
            var text : String? = password?.toString()?.trim()
            text?.let {
                passwordEnabled = !it.isNullOrEmpty()
                button.isEnabled = usernameEnabled && passwordEnabled
            }
        }
```

### Checking code for details.

## Visual result:
<p align = "center">
<img src="/images/01.gif" width="300">
</p>
