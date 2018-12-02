package com.example.iitomoki.generate_qr

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AndroidRuntimeException
import android.widget.ImageView

import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //QRコード化する文字列
        val data = "https://www.google.com"
        //QRコード画像の大きさを指定(pixel)
        val size = 500

        try {
            val barcodeEncoder = BarcodeEncoder()
            //QRコードをBitmapで作成
            val bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, size, size)

            //作成したQRコードを画面上に配置
            val imageViewQrCode = findViewById<ImageView>(R.id.imageView)
            imageViewQrCode.setImageBitmap(bitmap)

        } catch (e: WriterException) {
            throw AndroidRuntimeException("Barcode Error.", e)
        }


    }
}