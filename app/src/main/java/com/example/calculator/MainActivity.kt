package com.example.calculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun submit(v: View)
    {
        when(v.id)
        {
            R.id.submit ->
            {
                var i = Intent(this,Main2Activity::class.java)
                var num1 = inputnum1.text.toString().toInt()
                var num2 = inputnum2.text.toString().toInt()

                var bundle = Bundle()
                bundle.putInt("num1",num1)
                bundle.putInt("num2",num2)
                i.putExtras(bundle)
                startActivityForResult(i,1001)
            }
            R.id.reset ->
            {
                inputnum1.getText().clear()
                inputnum2.getText().clear()
                result.text = "Result: "
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1001 && resultCode == Activity.RESULT_OK)
        {
            var res = data?.getIntExtra("result",0)
            result.text = "Result: $res"
        }
    }
}
