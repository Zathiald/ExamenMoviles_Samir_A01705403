package com.itesm.examenmoviles.framework.views.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.itesm.examenmoviles.R
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llamada a la función para hacer la solicitud
        fetchFromServer()
    }

    private fun fetchFromServer() {
        // Usa el cliente OkHttp para hacer la solicitud
        val client = OkHttpClient()

        // Construye la solicitud con la URL base
        val request = Request.Builder()
            .url(com.itesm.examenmoviles.utils.Constants.BASE_URL)
            .build()

        // Ejecuta la solicitud en un hilo separado para no bloquear la UI
        thread {
            try {
                val response: Response = client.newCall(request).execute()

                // Verifica si la respuesta es exitosa y loguea el resultado
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    Log.d("MainActivity", "Response: $responseBody")
                } else {
                    Log.e("MainActivity", "Request failed: ${response.code}")
                }
            } catch (e: IOException) {
                Log.e("MainActivity", "Network error", e)
            }
        }
    }
}
