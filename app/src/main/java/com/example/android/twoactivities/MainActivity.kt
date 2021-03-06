package com.example.android.twoactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
const val TEXT_REQUEST = 1

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.simpleName
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mReplyHeadTextView.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyTextView.text.toString())
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button Clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }
}

//???????????????????????? ?????????????? ???? ?????????????? 12 ?????????????????? ?? ?????????????????????? Andersen-HW2-Tasks_1.2_and_1.4, ??????
// ?????????????????? ?????????????????????? ?????? ?????????????? ???????????????????? Hello Toast

//???????????? ???? ?????????????? ???? ?????????? ???? ??????????????:

//Question 1
//What changes are made when you add a second Activity to your app by choosing File > New >
// Activity and an Activity template? Choose one:
//
//Answer: The second Activity is added as a Java class, the XML layout file is created, and
// the AndroidManifest.xml file is changed to declare a second Activity.

//Question 2
//What happens if you remove the android:parentActivityName and the <meta-data> elements from the
// second Activity declaration in the AndroidManifest.xml file? Choose one:
//
//Answer: The Up button in the app bar no longer appears in the second Activity to send the user
// back to the parent Activity.

//Question 3
//Which constructor method do you use to create a new explicit Intent? Choose one:
//
//Answer: new Intent(Context context, Class<?> class)

//Question 4
//In the HelloToast app homework, how do you add the current value of the count to the Intent? Choose one:
//
//Answer: As an Intent extra

//Question 5
//In the HelloToast app homework, how do you display the current count in the second "Hello" Activity?
// Choose one:
//
//Answer: All of the above.