package com.example.florabliss

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.florabliss.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import java.util.*

class CartActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Initializing UI elements
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val addressInput = findViewById<EditText>(R.id.addressInput)
        val flowerSpinner = findViewById<Spinner>(R.id.flowerSpinner)
        val quantitySlider = findViewById<Slider>(R.id.quantitySlider)
        val quantityText = findViewById<TextView>(R.id.quantityText)
        val datePickerButton = findViewById<Button>(R.id.datePickerButton)
        val timePickerButton = findViewById<Button>(R.id.timePickerButton)
        val deliveryTypeGroup = findViewById<RadioGroup>(R.id.deliveryTypeGroup)
        val standardDelivery = findViewById<RadioButton>(R.id.standardDelivery)
        val expressDelivery = findViewById<RadioButton>(R.id.expressDelivery)
        val addonChocolate = findViewById<CheckBox>(R.id.addonChocolate)
        val addonCard = findViewById<CheckBox>(R.id.addonCard)
        val customMessage = findViewById<EditText>(R.id.customMessage)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val ratingText = findViewById<TextView>(R.id.ratingText)
        val submitButton = findViewById<FloatingActionButton>(R.id.submitFab)

        // Spinner setup
        val flowerOptions = arrayOf("Roses", "Lilies", "Tulips", "Orchids", "Sunflowers")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, flowerOptions)
        flowerSpinner.adapter = spinnerAdapter

        // Quantity Slider Listener
        quantitySlider.addOnChangeListener { _, value, _ ->
            quantityText.text = "Select Quantity: ${value.toInt()}"
        }

        // Date Picker
        datePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                datePickerButton.text = "Delivery Date: $selectedDay/${selectedMonth + 1}/$selectedYear"
            }, year, month, day)
            datePicker.show()
        }

        // Time Picker
        timePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                timePickerButton.text = "Delivery Time: $selectedHour:$selectedMinute"
            }, hour, minute, true)
            timePicker.show()
        }

        // Radio Button Selection Handling
        var selectedDeliveryType = "Standard" // Default selection
        deliveryTypeGroup.setOnCheckedChangeListener { _, checkedId ->
            selectedDeliveryType = when (checkedId) {
                R.id.standardDelivery -> "Standard"
                R.id.expressDelivery -> "Express"
                else -> "Standard"
            }
        }

        // Checkbox Handling - Add-ons
        val addOns = mutableListOf<String>()
        addonChocolate.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) addOns.add("Chocolates") else addOns.remove("Chocolates")
        }
        addonCard.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) addOns.add("Greeting Card") else addOns.remove("Greeting Card")
        }

        // Rating Bar Handling (Updates rating dynamically)
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            ratingText.text = "Rate Our Service: $rating Stars"
        }

        // Submit Button Click Listener
        submitButton.setOnClickListener {
            val orderSummary = """
                Order Summary:
                Name: ${nameInput.text}
                Email: ${emailInput.text}
                Address: ${addressInput.text}
                Flower: ${flowerSpinner.selectedItem}
                Quantity: ${quantitySlider.value.toInt()}
                Delivery Type: $selectedDeliveryType
                Add-ons: ${addOns.joinToString(", ")}
                Custom Message: ${customMessage.text}
                Rating: ${ratingBar.rating} Stars
            """.trimIndent()

            Toast.makeText(this, "Order Confirmed! ✅\n$orderSummary", Toast.LENGTH_LONG).show()
        }
    }
}
