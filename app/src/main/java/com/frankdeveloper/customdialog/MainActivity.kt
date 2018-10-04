package com.frankdeveloper.customdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAlert = findViewById<Button>(R.id.btnShowAlert)
        btnAlert.setOnClickListener {
            alertCustom()
        }


    }

    fun alertCustom(){
        val dialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_login, null)

        val edtCorreo = view.findViewById<EditText>(R.id.edtCorreo)
        val edtPass = view.findViewById<EditText>(R.id.edtPass)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        dialog.setView(view)
        dialog.setCancelable(true)

        val dialogShow = dialog.create()
        dialogShow.show()

        btnLogin.setOnClickListener {
            if (!edtCorreo.text.isEmpty() && !edtPass.text.isEmpty()){
                Toast.makeText(this, getText(R.string.msj_exito), Toast.LENGTH_SHORT).show()
                dialogShow.dismiss()
            }else
                Toast.makeText(this, getText(R.string.msj_error), Toast.LENGTH_SHORT).show()
        }

    }

}
