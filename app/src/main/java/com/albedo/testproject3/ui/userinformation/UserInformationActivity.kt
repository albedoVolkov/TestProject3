package com.albedo.testproject3.ui.userinformation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.albedo.testproject3.R
import com.albedo.testproject3.data.models.UserUIState
import com.albedo.testproject3.databinding.ActivityUserInformationBinding
import com.albedo.testproject3.services.ConstantsSource
import com.albedo.testproject3.viewmodels.UserInformationActivityViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class UserInformationActivity : AppCompatActivity() {

    val TAG = "UserInformationActivity"

    private lateinit var binding: ActivityUserInformationBinding
    private val viewModel: UserInformationActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = this.intent.extras
        if (bundle != null) {
            val stringId = bundle.getString(ConstantsSource.KeyFromMAToUIA)
            Log.d(TAG, "bundle : id - $stringId")

            if (stringId != null && stringId != "0" && stringId != "-1") {
                viewModel.setItemInViewModel(stringId)
            } else {
                finish()
            }
        } else {
            finish()
        }


        requireData()

        setListeners(viewModel.mainItem)
    }

    private fun <T> views(block: ActivityUserInformationBinding.() -> T): T? = binding.block()


    private fun requireData() {

        viewModel.data.onEach {
            setViews(it)
            setListeners(it)
        }.launchIn(viewModel.viewModelScope)
    }

    private fun setViews(item : UserUIState) {

        views {
            Glide.with(this@UserInformationActivity)
                .load(item.large)
                .error(R.drawable.not_loaded_image)
                .placeholder(R.drawable.not_loaded_image)
                .into(imgPerson)

            txtCellInfo.text = item.cell
            txtEmailInfo.text = item.email
            txtGenderInfo.text = item.gender
            txtNatInfo.text = item.nat
            txtPhoneInfo.text = item.phone
            txtBodAgeInfo.text = item.bodAge.toString()
            txtBodDateInfo.text = item.bodDate.toString()
            txtIdInfo.text = item.id

            txtLocationCityInfo.text = item.city
            txtLocationStreetInfo.text = item.streetName
            txtLocationCountryInfo.text = item.country
            txtLocationPostcodeInfo.text = item.postcode
            txtLocationStateInfo.text = item.state
            txtLocationTimezoneDescriptionInfo.text = item.timeZoneDescription
            txtLocationTimezoneOffsetInfo.text = item.timeZoneOffset
            txtLocationCoordinatesLatitudeInfo.text = item.locationLatitude.toString()
            txtLocationCoordinatesLongitudeInfo.text = item.locationLongitude.toString()

            txtLoginPasswordInfo.text = item.password
            txtLoginSaltInfo.text = item.salt
            txtLoginUsernameInfo.text = item.username
            txtLoginUuidInfo.text = item.uuid
            txtLoginMd5Info.text = item.md5
            txtLoginSha1Info.text = item.sha1
            txtLoginSha256Info.text = item.sha256

            txtNameFirstInfo.text = item.first
            txtNameLastInfo.text = item.last
            txtNameTitleInfo.text = item.title

            txtRegistrationAgeInfo.text = item.registrationAge.toString()
            txtRegistrationDateInfo.text = item.registrationDate.toString()
        }
    }

    private fun setListeners(item : UserUIState) {
        views {


            toolBar.btnToMA.setOnClickListener {
                finish()
            }


            containerLocation.setOnClickListener {
                val uri = "http://maps.google.com/maps?daddr=${item.locationLatitude},${item.locationLongitude} (Where the party is at)"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            }


            txtEmailInfo.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "*/*"
                    putExtra(Intent.EXTRA_EMAIL, arrayListOf<String>(item.email))
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }



            txtPhoneInfo.setOnClickListener {
                val phoneNumber = item.phone
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:$phoneNumber"))
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }
}


