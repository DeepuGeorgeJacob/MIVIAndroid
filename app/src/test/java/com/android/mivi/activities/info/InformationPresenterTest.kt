package com.android.mivi.activities.info

import com.android.mivi.activities.info.dal.Information
import com.android.mivi.activities.login.repository.MIVDataSource
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.nio.charset.Charset

class InformationPresenterTest {
    private val dataSource: MIVDataSource = Mockito.mock(MIVDataSource::class.java)
    private lateinit var view: InformationContract.View
    private var presenter: InformationPresenter? = null

    @Before
    fun setUp() {
        view = mock(InformationContract.View::class.java)
        presenter = InformationPresenter(view, dataSource)
    }

    @After
    fun tearDown() {
        presenter = null
    }

    @Test
    fun onStart() {
        val list = ArrayList<Information>()
        `when`(dataSource.getJson()).thenReturn(mockJson())
        presenter!!.onStart()
        verify(view).updateDataset(list)

    }
    fun mockJson(): String {
        val byte = "{\n" +
                "  \"data\": {\n" +
                "    \"type\": \"accounts\",\n" +
                "    \"id\": \"2593177\",\n" +
                "    \"attributes\": {\n" +
                "      \"payment-type\": \"prepaid\",\n" +
                "      \"unbilled-charges\": null,\n" +
                "      \"next-billing-date\": null,\n" +
                "      \"title\": \"Ms\",\n" +
                "      \"first-name\": \"Joe\",\n" +
                "      \"last-name\": \"Bloggs\",\n" +
                "      \"date-of-birth\": \"1985-01-01\",\n" +
                "      \"contact-number\": \"0404000000\",\n" +
                "      \"email-address\": \"test@mivi.com\",\n" +
                "      \"email-address-verified\": false,\n" +
                "      \"email-subscription-status\": false\n" +
                "    },\n" +
                "    \"links\": {\n" +
                "      \"self\": \"http://localhost:3000/accounts/2593177\"\n" +
                "    },\n" +
                "    \"relationships\": {\n" +
                "      \"services\": {\n" +
                "        \"links\": {\n" +
                "          \"related\": \"http://localhost:3000/services/0468874507\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"included\": [\n" +
                "    {\n" +
                "      \"type\": \"services\",\n" +
                "      \"id\": \"0468874507\",\n" +
                "      \"attributes\": {\n" +
                "        \"msn\": \"0468874507\",\n" +
                "        \"credit\": 1200,\n" +
                "        \"credit-expiry\": \"2016-11-20\",\n" +
                "        \"data-usage-threshold\": false\n" +
                "      },\n" +
                "      \"links\": {\n" +
                "        \"self\": \"http://localhost:3000/services/0468874507\"\n" +
                "      },\n" +
                "      \"relationships\": {\n" +
                "        \"subscriptions\": {\n" +
                "          \"links\": {\n" +
                "            \"related\": \"http://localhost:3000/services/0468874507/subscriptions\"\n" +
                "          },\n" +
                "          \"data\": [\n" +
                "            {\n" +
                "              \"type\": \"subscriptions\",\n" +
                "              \"id\": \"0468874507-0\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"subscriptions\",\n" +
                "      \"id\": \"0468874507-0\",\n" +
                "      \"attributes\": {\n" +
                "        \"included-data-balance\": 52400,\n" +
                "        \"included-credit-balance\": null,\n" +
                "        \"included-rollover-credit-balance\": null,\n" +
                "        \"included-rollover-data-balance\": null,\n" +
                "        \"included-international-talk-balance\": null,\n" +
                "        \"expiry-date\": \"2016-11-19\",\n" +
                "        \"auto-renewal\": true,\n" +
                "        \"primary-subscription\": true\n" +
                "      },\n" +
                "      \"links\": {\n" +
                "        \"self\": \"http://localhost:3000/services/0468874507/subscriptions/0468874507-0\"\n" +
                "      },\n" +
                "      \"relationships\": {\n" +
                "        \"service\": {\n" +
                "          \"links\": {\n" +
                "            \"related\": \"http://localhost:3000/services/0468874507\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"product\": {\n" +
                "          \"data\": {\n" +
                "            \"type\": \"products\",\n" +
                "            \"id\": \"0\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"downgrade\": {\n" +
                "          \"data\": null\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"products\",\n" +
                "      \"id\": \"4000\",\n" +
                "      \"attributes\": {\n" +
                "        \"name\": \"UNLIMITED 7GB\",\n" +
                "        \"included-data\": null,\n" +
                "        \"included-credit\": null,\n" +
                "        \"included-international-talk\": null,\n" +
                "        \"unlimited-text\": true,\n" +
                "        \"unlimited-talk\": true,\n" +
                "        \"unlimited-international-text\": false,\n" +
                "        \"unlimited-international-talk\": false,\n" +
                "        \"price\": 3990\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}"
        return String(byte.toByteArray(), Charset.forName("UTF-8"))
    }
}