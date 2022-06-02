package com.example.alfaproject.servises;

import com.example.alfaproject.parsers.CurrencyParser;
import com.example.alfaproject.repositories.FeignCurrencyRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @Mock
    private FeignCurrencyRepo feignCurrencyRepo;

    @Spy
    private CurrencyParser currencyParser;

    @InjectMocks
    private CurrencyService currencyService;


    @Test
    void getCurrencyGrow() throws JsonProcessingException {
        //given
        String neededCurr = "RUB";

        Mockito.when(feignCurrencyRepo.getLatestCurrency()).thenReturn("{\"disclaimer\":\"Usage subject to terms: https://openexchangerates.org/terms\",\"license\":\"https://openexchangerates.org/license\",\"timestamp\":1654192800,\"base\":\"USD\",\"rates\":{\"AED\":3.673,\"AFN\":89.012752,\"ALL\":112.7,\"AMD\":446.111175,\"ANG\":1.8027,\"AOA\":426.46885,\"ARS\":120.474533,\"AUD\":1.376548,\"AWG\":1.8,\"AZN\":1.7,\"BAM\":1.829101,\"BBD\":2,\"BDT\":89.097115,\"BGN\":1.8206,\"BHD\":0.377013,\"BIF\":2027,\"BMD\":1,\"BND\":1.375125,\"BOB\":6.886751,\"BRL\":4.7959,\"BSD\":1,\"BTC\":0.000033103226,\"BTN\":77.557803,\"BWP\":12.007837,\"BYN\":3.377397,\"BZD\":2.016207,\"CAD\":1.257188,\"CDF\":2002.5,\"CHF\":0.958585,\"CLF\":0.02944,\"CLP\":812.35,\"CNH\":6.65782,\"CNY\":6.6603,\"COP\":3784.294682,\"CRC\":682.951856,\"CUC\":1,\"CUP\":25.75,\"CVE\":103.08,\"CZK\":22.9593,\"DJF\":177.55,\"DKK\":6.92191,\"DOP\":55.15,\"DZD\":144.865,\"EGP\":18.659061,\"ERN\":15.000001,\"ETB\":51.6,\"EUR\":0.930505,\"FJD\":2.1368,\"FKP\":0.794818,\"GBP\":0.794818,\"GEL\":2.98,\"GGP\":0.794818,\"GHS\":7.825,\"GIP\":0.794818,\"GMD\":54.1125,\"GNF\":8837.5,\"GTQ\":7.711415,\"GYD\":209.270728,\"HKD\":7.84516,\"HNL\":24.56,\"HRK\":7.0093,\"HTG\":113.027875,\"HUF\":366.94321,\"IDR\":14441.416667,\"ILS\":3.3303,\"IMP\":0.794818,\"INR\":77.392103,\"IQD\":1460,\"IRR\":42300,\"ISK\":127.63,\"JEP\":0.794818,\"JMD\":154.083325,\"JOD\":0.709,\"JPY\":129.8325,\"KES\":116.85,\"KGS\":79.547701,\"KHR\":4061,\"KMF\":458.749854,\"KPW\":900,\"KRW\":1245.3025,\"KWD\":0.306015,\"KYD\":0.833548,\"KZT\":435.356279,\"LAK\":13473.926317,\"LBP\":1516.5,\"LKR\":360.089571,\"LRD\":151.999978,\"LSL\":15.525,\"LYD\":4.775,\"MAD\":9.84,\"MDL\":19.029579,\"MGA\":3995,\"MKD\":57.622616,\"MMK\":1851.951094,\"MNT\":3105.3554,\"MOP\":8.083813,\"MRU\":36.51,\"MUR\":43.600229,\"MVR\":15.44,\"MWK\":816.25,\"MXN\":19.559181,\"MYR\":4.391,\"MZN\":63.849999,\"NAD\":15.56,\"NGN\":415.099715,\"NIO\":35.82,\"NOK\":9.37899,\"NPR\":124.092289,\"NZD\":1.524193,\"OMR\":0.385033,\"PAB\":1,\"PEN\":3.70975,\"PGK\":3.525,\"PHP\":52.813997,\"PKR\":197.598969,\"PLN\":4.255545,\"PYG\":6853.404087,\"QAR\":3.64125,\"RON\":4.5988,\"RSD\":109.275,\"RUB\":63.749998,\"RWF\":1028.5,\"SAR\":3.750704,\"SBD\":8.116969,\"SCR\":13.618791,\"SDG\":455.5,\"SEK\":9.705,\"SGD\":1.370817,\"SHP\":0.794818,\"SLL\":12887.2,\"SOS\":583,\"SRD\":21.1215,\"SSP\":130.26,\"STD\":22994,\"STN\":23.15,\"SVC\":8.752578,\"SYP\":2512.53,\"SZL\":15.525,\"THB\":34.2715,\"TJS\":11.37779,\"TMT\":3.51,\"TND\":3.0365,\"TOP\":2.306693,\"TRY\":16.473505,\"TTD\":6.778922,\"TWD\":29.202499,\"TZS\":2329,\"UAH\":29.531041,\"UGX\":3755.977862,\"USD\":1,\"UYU\":39.974162,\"UZS\":11015,\"VES\":5.0842,\"VND\":23198,\"VUV\":114.629832,\"WST\":2.612952,\"XAF\":610.371424,\"XAG\":0.04491657,\"XAU\":0.00053529,\"XCD\":2.70255,\"XDR\":0.728421,\"XOF\":610.371424,\"XPD\":0.00048782,\"XPF\":111.038811,\"XPT\":0.00097277,\"YER\":250.300047,\"ZAR\":15.463719,\"ZMW\":17.16923,\"ZWL\":322}}");
        Mockito.when(feignCurrencyRepo.getCurrencyByDate(LocalDate.of(2022, 6,2).toString())).thenReturn("{\"disclaimer\":\"Usage subject to terms: https://openexchangerates.org/terms\",\"license\":\"https://openexchangerates.org/license\",\"timestamp\":1654127998,\"base\":\"USD\",\"rates\":{\"AED\":3.6731,\"AFN\":89.463487,\"ALL\":112.661581,\"AMD\":446.121845,\"ANG\":1.80195,\"AOA\":424.12365,\"ARS\":120.31434,\"AUD\":1.394402,\"AWG\":1.8005,\"AZN\":1.7,\"BAM\":1.824553,\"BBD\":2,\"BDT\":89.059664,\"BGN\":1.837299,\"BHD\":0.376987,\"BIF\":2044.171196,\"BMD\":1,\"BND\":1.372079,\"BOB\":6.88381,\"BRL\":4.8171,\"BSD\":1,\"BTC\":0.00003354298,\"BTN\":77.513035,\"BWP\":11.995616,\"BYN\":3.377023,\"BZD\":2.015392,\"CAD\":1.266781,\"CDF\":2002.395934,\"CHF\":0.963079,\"CLF\":0.029848,\"CLP\":823.827682,\"CNH\":6.70271,\"CNY\":6.6862,\"COP\":3793.631183,\"CRC\":673.461436,\"CUC\":1,\"CUP\":25.75,\"CVE\":103.64,\"CZK\":23.2199,\"DJF\":177.894679,\"DKK\":6.9846,\"DOP\":55.114156,\"DZD\":145.100907,\"EGP\":18.6348,\"ERN\":15.000001,\"ETB\":51.798139,\"EUR\":0.938853,\"FJD\":2.1506,\"FKP\":0.801026,\"GBP\":0.801026,\"GEL\":3.005,\"GGP\":0.801026,\"GHS\":7.814212,\"GIP\":0.801026,\"GMD\":54.15,\"GNF\":8843.683351,\"GTQ\":7.68366,\"GYD\":209.179632,\"HKD\":7.847655,\"HNL\":24.554222,\"HRK\":7.0733,\"HTG\":111.980961,\"HUF\":372.268667,\"IDR\":14555.5,\"ILS\":3.34256,\"IMP\":0.801026,\"INR\":77.583441,\"IQD\":1459.692694,\"IRR\":42400,\"ISK\":128.54,\"JEP\":0.801026,\"JMD\":153.833633,\"JOD\":0.7102,\"JPY\":130.12571501,\"KES\":116.797402,\"KGS\":81.510065,\"KHR\":4061.755687,\"KMF\":462.049999,\"KPW\":900,\"KRW\":1247.3,\"KWD\":0.306255,\"KYD\":0.833248,\"KZT\":431.176533,\"LAK\":13448.227074,\"LBP\":1516.158832,\"LKR\":359.438094,\"LRD\":151.99996,\"LSL\":15.541789,\"LYD\":4.759044,\"MAD\":9.865697,\"MDL\":18.986223,\"MGA\":4023.777472,\"MKD\":57.479357,\"MMK\":1851.18433,\"MNT\":3105.3554,\"MOP\":8.07989,\"MRU\":36.484572,\"MUR\":43.396634,\"MVR\":15.445,\"MWK\":816.25,\"MXN\":19.7187,\"MYR\":4.3821,\"MZN\":63.875002,\"NAD\":15.56,\"NGN\":415.015816,\"NIO\":35.836413,\"NOK\":9.48169,\"NPR\":124.020734,\"NZD\":1.54346,\"OMR\":0.385013,\"PAB\":1,\"PEN\":3.714352,\"PGK\":3.548958,\"PHP\":52.479996,\"PKR\":197.715763,\"PLN\":4.306542,\"PYG\":6885.31193,\"QAR\":3.641,\"RON\":4.6374,\"RSD\":110.236784,\"RUB\":63.499993,\"RWF\":1022.788872,\"SAR\":3.749898,\"SBD\":8.117017,\"SCR\":13.579401,\"SDG\":455,\"SEK\":9.8474,\"SGD\":1.3751,\"SHP\":0.801026,\"SLL\":12887.2,\"SOS\":580.230838,\"SRD\":21.1215,\"SSP\":130.26,\"STD\":22994,\"STN\":23.375,\"SVC\":8.748542,\"SYP\":2512.53,\"SZL\":15.537979,\"THB\":34.373583,\"TJS\":12.4421,\"TMT\":3.5,\"TND\":3.0365,\"TOP\":2.303992,\"TRY\":16.4408,\"TTD\":6.78054,\"TWD\":29.143301,\"TZS\":2329,\"UAH\":29.518635,\"UGX\":3799.343646,\"USD\":1,\"UYU\":39.918503,\"UZS\":10982.924771,\"VES\":5.05875,\"VND\":23201.428699,\"VUV\":114.629832,\"WST\":2.612952,\"XAF\":615.846892,\"XAG\":0.04588324,\"XAU\":0.00054168,\"XCD\":2.70255,\"XDR\":0.725343,\"XOF\":615.846892,\"XPD\":0.00049977,\"XPF\":112.034909,\"XPT\":0.00100265,\"YER\":250.250057,\"ZAR\":15.589521,\"ZMW\":17.271981,\"ZWL\":322}}");

        //when
        boolean grow = currencyService.getCurrencyGrow(neededCurr);

        //then
        Assertions.assertFalse(grow);
    }
}