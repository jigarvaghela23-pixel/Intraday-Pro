
package com.intradaypro.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 30, 24, 24)
            setBackgroundColor(Color.rgb(12, 18, 32))
        }

        fun addText(text: String, size: Float, color: Int) {
            root.addView(TextView(this).apply {
                this.text = text
                textSize = size
                setTextColor(color)
                setPadding(0, 12, 0, 12)
            })
        }

        addText("INTRADAY PRO", 27f, Color.WHITE)
        addText("NSE STOCK ANALYSIS", 13f, Color.LTGRAY)

        addText("MARKET OVERVIEW", 17f, Color.WHITE)
        addText("NIFTY 50     Live data not connected", 16f, Color.YELLOW)
        addText("BANK NIFTY   Live data not connected", 16f, Color.YELLOW)

        addText("STOCK SCANNER", 20f, Color.WHITE)

        val search = EditText(this).apply {
            hint = "Enter stock symbol (e.g. RELIANCE)"
            setSingleLine(true)
            setTextColor(Color.WHITE)
            setHintTextColor(Color.LTGRAY)
        }
        root.addView(search)

        val button = Button(this).apply {
            text = "ANALYZE STOCK"
        }
        root.addView(button)

        val result = TextView(this).apply {
            text = "Your stock analysis will appear here."
            textSize = 16f
            setTextColor(Color.WHITE)
            setPadding(0, 24, 0, 24)
        }
        root.addView(result)

        button.setOnClickListener {
            val symbol = search.text.toString().trim().uppercase()
            result.text = if (symbol.isEmpty()) {
                "Please enter a stock symbol."
            } else {
                "$symbol\nWaiting for market data connection.\nNo trade signal available yet."
            }
        }

        addText("TRADE SIGNALS", 20f, Color.WHITE)
        addText("BUY  •  SELL  •  NO TRADE", 16f, Color.GREEN)
        addText("VWAP | EMA | RSI | MACD | SUPERTREND", 13f, Color.LTGRAY)

        setContentView(ScrollView(this).apply {
            addView(root)
        })
    }
}
