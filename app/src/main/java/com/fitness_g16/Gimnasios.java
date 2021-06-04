package com.fitness_g16;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.fitness_g16.databinding.ActivityGimnasiosBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class Gimnasios extends FragmentActivity implements OnMapReadyCallback {


        private static final String TAG = Gimnasios.class.getSimpleName();
    private GoogleMap mMap;
    private ActivityGimnasiosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGimnasiosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();
        boolean success = googleMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json)));

        if (!success) {
            Log.e(TAG, "Style parsing failed.");
        }
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng gimnasios = new LatLng(13.7045,  -89.21382);
        mMap.addMarker(new MarkerOptions().position(gimnasios).title("Gimnasios Cerca de ti"));
        LatLng gimnasios2= new LatLng(14.1554250249561,-89.0178226415552);
        mMap.addMarker(new MarkerOptions().position(gimnasios2).title("Abrego Gym").snippet("telefono:--"));
        LatLng gimnasios3= new LatLng(14.0904233235949,-88.9560512982941);
        mMap.addMarker(new MarkerOptions().position(gimnasios3).title("Energym").snippet("telefono:--"));
        LatLng gimnasios4= new LatLng(14.0795129812735,-88.9750382722403);
        mMap.addMarker(new MarkerOptions().position(gimnasios4).title("Gimnasio Monge").snippet("telefono:--"));
        LatLng gimnasios5= new LatLng(14.0268666818975,-88.8838991078324);
        mMap.addMarker(new MarkerOptions().position(gimnasios5).title("Asociación comunal Tamarindo").snippet("telefono:--"));
        LatLng gimnasios6= new LatLng(14.0155041693729,-88.8959017023019);
        mMap.addMarker(new MarkerOptions().position(gimnasios6).title("Gimnasio y Polideportivo De San Antionio Los Ranchos").snippet("telefono:--"));
        LatLng gimnasios7= new LatLng(14.0433242837477,-88.9367037253903);
        mMap.addMarker(new MarkerOptions().position(gimnasios7).title("Smartfitness").snippet("telefono:--"));
        LatLng gimnasios8= new LatLng(14.0437203554872,-88.9412971770701);
        mMap.addMarker(new MarkerOptions().position(gimnasios8).title("Fitness Center").snippet("telefono:--"));
        LatLng gimnasios9= new LatLng(14.0422349874976,-88.9346111712845);
        mMap.addMarker(new MarkerOptions().position(gimnasios9).title("Bros Gym").snippet("telefono:--"));
        LatLng gimnasios10= new LatLng(14.0413437563086,-88.9362443831206);
        mMap.addMarker(new MarkerOptions().position(gimnasios10).title("Black Scorpion Chalatenango").snippet("telefono:--"));
        LatLng gimnasios11= new LatLng(14.0412942329122,-88.9388983385735);
        mMap.addMarker(new MarkerOptions().position(gimnasios11).title("Fibra Gym").snippet("telefono:--"));
        LatLng gimnasios12= new LatLng(14.1133871649966,-89.0021867790044);
        mMap.addMarker(new MarkerOptions().position(gimnasios12).title("Cancha El Chilamate").snippet("telefono:--"));
        LatLng gimnasios13= new LatLng(14.3152818004811,-89.0233952335147);
        mMap.addMarker(new MarkerOptions().position(gimnasios13).title("Cancha de Futbol San Fernando Viejo").snippet("telefono:--"));
        LatLng gimnasios14= new LatLng(14.3637666168363,-89.0834821007381);
        mMap.addMarker(new MarkerOptions().position(gimnasios14).title("Cancha de Futbol Cantón Las Granadillas").snippet("telefono:--"));
        LatLng gimnasios15= new LatLng(13.778934893405,-87.830181305327);
        mMap.addMarker(new MarkerOptions().position(gimnasios15).title("Cancha de Futbol El Trapichito").snippet("telefono:--"));
        LatLng gimnasios16= new LatLng(13.640776999836,-87.8847463521909);
        mMap.addMarker(new MarkerOptions().position(gimnasios16).title("Strong Gym").snippet("telefono:--"));
        LatLng gimnasios17= new LatLng(13.5954786384368,-87.8347781012222);
        mMap.addMarker(new MarkerOptions().position(gimnasios17).title("PowerGym").snippet("telefono:--"));
        LatLng gimnasios18= new LatLng(13.5666556703854,-87.9273368330677);
        mMap.addMarker(new MarkerOptions().position(gimnasios18).title("Cancha Los Morenos").snippet("telefono:--"));
        LatLng gimnasios19= new LatLng(13.4372607626715,-87.9630710761168);
        mMap.addMarker(new MarkerOptions().position(gimnasios19).title("Cancha CD Atlas").snippet("telefono:--"));
        LatLng gimnasios20= new LatLng(13.4244208868668,-87.9369584232367);
        mMap.addMarker(new MarkerOptions().position(gimnasios20).title("Campo El Milán").snippet("telefono:--"));
        LatLng gimnasios21= new LatLng(13.4136593292086,-87.9422842544647);
        mMap.addMarker(new MarkerOptions().position(gimnasios21).title("Estadio Agua Fría").snippet("telefono:--"));
        LatLng gimnasios22= new LatLng(13.3903570355392,-88.0214217999582);
        mMap.addMarker(new MarkerOptions().position(gimnasios22).title("GyM Luce Roca Benitez").snippet("telefono:--"));
        LatLng gimnasios23= new LatLng(13.3468296697734,-87.9417142514671);
        mMap.addMarker(new MarkerOptions().position(gimnasios23).title("Campo El Jicaro").snippet("telefono:--"));
        LatLng gimnasios24= new LatLng(13.3418309369142,-87.842718155868);
        mMap.addMarker(new MarkerOptions().position(gimnasios24).title("Parque INDES").snippet("telefono:--"));
        LatLng gimnasios25= new LatLng(13.3434379325005,-87.8465214228646);
        mMap.addMarker(new MarkerOptions().position(gimnasios25).title("Bull Gym").snippet("telefono:--"));
        LatLng gimnasios26= new LatLng(13.3371063354128,-87.843811566315);
        mMap.addMarker(new MarkerOptions().position(gimnasios26).title("Gimnasio Municipal El Rápido").snippet("telefono:--"));
        LatLng gimnasios27= new LatLng(13.2941406234195,-87.8696632359251);
        mMap.addMarker(new MarkerOptions().position(gimnasios27).title("Cancha Municipal Borromeo").snippet("telefono:--"));
        LatLng gimnasios28= new LatLng(13.2220638078653,-87.9894531890296);
        mMap.addMarker(new MarkerOptions().position(gimnasios28).title("Cancha de Fútbol La Billal").snippet("telefono:--"));
        LatLng gimnasios29= new LatLng(13.7293521445333,-88.8103490577674);
        mMap.addMarker(new MarkerOptions().position(gimnasios29).title("Body Power Gym").snippet("telefono:--"));
        LatLng gimnasios30= new LatLng(13.672217450856,-88.8048599679768);
        mMap.addMarker(new MarkerOptions().position(gimnasios30).title("Cancha de San José Cerro Grande").snippet("telefono:--"));
        LatLng gimnasios31= new LatLng(13.6798141925254,-88.7666489775142);
        mMap.addMarker(new MarkerOptions().position(gimnasios31).title("Cancha Sintética").snippet("telefono:--"));
        LatLng gimnasios32= new LatLng(13.6477860022866,-88.7826458198311);
        mMap.addMarker(new MarkerOptions().position(gimnasios32).title("Titanic Gym").snippet("telefono:--"));
        LatLng gimnasios33= new LatLng(13.6458919413524,-88.7780985531476);
        mMap.addMarker(new MarkerOptions().position(gimnasios33).title("Indes").snippet("telefono:--"));
        LatLng gimnasios34= new LatLng(13.6446296158609,-88.7840174409792);
        mMap.addMarker(new MarkerOptions().position(gimnasios34).title("Crossfit Elite SV").snippet("telefono:--"));
        LatLng gimnasios35= new LatLng(13.6437178183849,-88.7857497890047);
        mMap.addMarker(new MarkerOptions().position(gimnasios35).title("Titanic Gym 2").snippet("telefono:--"));
        LatLng gimnasios36= new LatLng(13.64132980486,-88.7875527299146);
        mMap.addMarker(new MarkerOptions().position(gimnasios36).title("Gym Maya").snippet("telefono:--"));
        LatLng gimnasios37= new LatLng(13.6417426475449,-88.7880990338578);
        mMap.addMarker(new MarkerOptions().position(gimnasios37).title("Unidad Médica Física y de rehabilitación ISSS").snippet("telefono:--"));
        LatLng gimnasios38= new LatLng(13.5792748127489,-88.7827271390183);
        mMap.addMarker(new MarkerOptions().position(gimnasios38).title("Cancha de Fútbol Sala").snippet("telefono:--"));
        LatLng gimnasios39= new LatLng(13.6620762965324,-88.5631138566526);
        mMap.addMarker(new MarkerOptions().position(gimnasios39).title("Cancha de Fútbol de Las Lajas").snippet("telefono:--"));
        LatLng gimnasios40= new LatLng(13.9443253072236,-89.8594562518961);
        mMap.addMarker(new MarkerOptions().position(gimnasios40).title("Gym Las Brisas").snippet("telefono:--"));
        LatLng gimnasios41= new LatLng(13.9258936629636,-89.8497395129996);
        mMap.addMarker(new MarkerOptions().position(gimnasios41).title("Wally Sport Fitness Gym").snippet("telefono:--"));
        LatLng gimnasios42= new LatLng(13.9244193040474,-89.8479167119484);
        mMap.addMarker(new MarkerOptions().position(gimnasios42).title("Viva Bike Ahuachapan").snippet("telefono:--"));
        LatLng gimnasios43= new LatLng(13.9234529255528,-89.8466361097051);
        mMap.addMarker(new MarkerOptions().position(gimnasios43).title("Train Hard Gym").snippet("telefono:--"));
        LatLng gimnasios44= new LatLng(13.9179653508136,-89.8483673297322);
        mMap.addMarker(new MarkerOptions().position(gimnasios44).title("Sculpture Gym").snippet("telefono:--"));
        LatLng gimnasios45= new LatLng(13.8619658928648,-89.7968934960089);
        mMap.addMarker(new MarkerOptions().position(gimnasios45).title("Ata's Gym").snippet("telefono:7057-3543"));
        LatLng gimnasios46= new LatLng(13.9748031947683,-89.699913334183);
        mMap.addMarker(new MarkerOptions().position(gimnasios46).title("Life Gym").snippet("telefono:7245-8572"));
        LatLng gimnasios47= new LatLng(13.973418271206,-89.7607758383473);
        mMap.addMarker(new MarkerOptions().position(gimnasios47).title("Ufc Gym United for Christ").snippet("telefono:--"));
        LatLng gimnasios48= new LatLng(13.9752231533575,-89.7567516296724);
        mMap.addMarker(new MarkerOptions().position(gimnasios48).title("Roca Gym").snippet("telefono:--"));
        LatLng gimnasios49= new LatLng(13.9742058578848,-89.753031772914);
        mMap.addMarker(new MarkerOptions().position(gimnasios49).title("JyJ FITNESS GYM").snippet("telefono:--"));
        LatLng gimnasios50= new LatLng(13.589547335638,-89.8304934276411);
        mMap.addMarker(new MarkerOptions().position(gimnasios50).title("Home Gym").snippet("telefono:--"));
        LatLng gimnasios51= new LatLng(13.5958613616136,-89.8207939630562);
        mMap.addMarker(new MarkerOptions().position(gimnasios51).title("Ironman Gym").snippet("telefono:--"));
        LatLng gimnasios52= new LatLng(13.6881022814625,-89.7360576882767);
        mMap.addMarker(new MarkerOptions().position(gimnasios52).title("Domo Deportivo Sonsonateco").snippet("telefono:--"));
        LatLng gimnasios53= new LatLng(13.709349599409,-89.7189292028882);
        mMap.addMarker(new MarkerOptions().position(gimnasios53).title("JV Fitness Center").snippet("telefono:--"));
        LatLng gimnasios54= new LatLng(13.7204925294609,-89.7366694198977);
        mMap.addMarker(new MarkerOptions().position(gimnasios54).title("Gimnasio Brizuela").snippet("telefono:--"));
        LatLng gimnasios55= new LatLng(13.7213884392869,-89.7206990922684);
        mMap.addMarker(new MarkerOptions().position(gimnasios55).title("Sport City").snippet("telefono:--"));
        LatLng gimnasios56= new LatLng(13.7216049474768,-89.7258993644924);
        mMap.addMarker(new MarkerOptions().position(gimnasios56).title("Yolis Gym").snippet("telefono:--"));
        LatLng gimnasios57= new LatLng(13.7286774387977,-89.7242649925958);
        mMap.addMarker(new MarkerOptions().position(gimnasios57).title("Gimnasio Municipal De Sonsonate").snippet("telefono:--"));
        LatLng gimnasios58= new LatLng(13.7254608407493,-89.7175306893627);
        mMap.addMarker(new MarkerOptions().position(gimnasios58).title("GET FIT GYM").snippet("telefono:--"));
        LatLng gimnasios59= new LatLng(13.727494128984,-89.7149684866467);
        mMap.addMarker(new MarkerOptions().position(gimnasios59).title("train hard gym").snippet("telefono:--"));
        LatLng gimnasios60= new LatLng(13.7372480564188,-89.7138419168029);
        mMap.addMarker(new MarkerOptions().position(gimnasios60).title("Gimnasio Municipal De Sonzacate").snippet("telefono:--"));
        LatLng gimnasios61= new LatLng(13.7316415382317,-89.730828490885);
        mMap.addMarker(new MarkerOptions().position(gimnasios61).title("INJUVE (Circulo Estudiantil de Sonsonate)").snippet("telefono:--"));
        LatLng gimnasios62= new LatLng(13.7516044070332,-89.6664098414709);
        mMap.addMarker(new MarkerOptions().position(gimnasios62).title("Hollywood Gym").snippet("telefono:--"));
        LatLng gimnasios63= new LatLng(13.8425987670056,-89.7428551483021);
        mMap.addMarker(new MarkerOptions().position(gimnasios63).title("Train Hard Gym Juayua").snippet("telefono:--"));
        LatLng gimnasios64= new LatLng(13.4950330691756,-89.2877041094059);
        mMap.addMarker(new MarkerOptions().position(gimnasios64).title("Palometos GYM").snippet("telefono:--"));
        LatLng gimnasios65= new LatLng(13.8435752288219,-89.4444652005094);
        mMap.addMarker(new MarkerOptions().position(gimnasios65).title("LEONIDAS GYM").snippet("telefono:--"));
        LatLng gimnasios66= new LatLng(13.850572466044,-89.4073093313602);
        mMap.addMarker(new MarkerOptions().position(gimnasios66).title("Personal Gym").snippet("telefono:--"));
        LatLng gimnasios67= new LatLng(13.7923649376192,-89.3491973259428);
        mMap.addMarker(new MarkerOptions().position(gimnasios67).title("Gimnasio Sitio Del Niño").snippet("telefono:7854-9753"));
        LatLng gimnasios68= new LatLng(13.6808333037082,-89.2842178094746);
        mMap.addMarker(new MarkerOptions().position(gimnasios68).title("Olympus Gym").snippet("telefono:--"));
        LatLng gimnasios69= new LatLng(13.6779813839667,-89.2712974554071);
        mMap.addMarker(new MarkerOptions().position(gimnasios69).title("Body Impact Merliot").snippet("telefono:2266-2888"));
        LatLng gimnasios70= new LatLng(13.6815027973933,-89.2523953182927);
        mMap.addMarker(new MarkerOptions().position(gimnasios70).title("HIIT EL SALVADOR").snippet("telefono:2229-4085"));
        LatLng gimnasios71= new LatLng(13.6783267347209,-89.2529253925533);
        mMap.addMarker(new MarkerOptions().position(gimnasios71).title("Be Fit  La Gran Via").snippet("telefono:2278-5858"));
        LatLng gimnasios72= new LatLng(13.6592509508679,-89.2776805065304);
        mMap.addMarker(new MarkerOptions().position(gimnasios72).title("Fit Life GyM").snippet("telefono:2249-0044"));
        LatLng gimnasios73= new LatLng(13.6647008630971,-89.2670982401177);
        mMap.addMarker(new MarkerOptions().position(gimnasios73).title("World Gym El Salvador").snippet("telefono:2243-4142"));
        LatLng gimnasios74= new LatLng(13.6676828372005,-89.2505899045138);
        mMap.addMarker(new MarkerOptions().position(gimnasios74).title("Body Impact").snippet("telefono:2564-2694"));
        LatLng gimnasios75= new LatLng(13.4588338684837,-88.1645755977716);
        mMap.addMarker(new MarkerOptions().position(gimnasios75).title("Gimnasio Silver Gym").snippet("telefono:2646-1185"));
        LatLng gimnasios76= new LatLng(13.466488771576,-88.1720516133585);
        mMap.addMarker(new MarkerOptions().position(gimnasios76).title("Planet Fitness Gym").snippet("telefono:2697-0290"));
        LatLng gimnasios77= new LatLng(13.474868214261,-88.1721787373202);
        mMap.addMarker(new MarkerOptions().position(gimnasios77).title("Gimnasio Gladiador").snippet("telefono:--"));
        LatLng gimnasios78= new LatLng(13.4741017005116,-88.1832136793774);
        mMap.addMarker(new MarkerOptions().position(gimnasios78).title("Nautiluss Gym San Miguel").snippet("telefono:2639-0803"));
        LatLng gimnasios79= new LatLng(13.4762270280507,-88.1772662755414);
        mMap.addMarker(new MarkerOptions().position(gimnasios79).title("Muros gym").snippet("telefono:--"));
        LatLng gimnasios80= new LatLng(13.4799898569402,-88.1791293183857);
        mMap.addMarker(new MarkerOptions().position(gimnasios80).title("Gimnasio Santa Sofia").snippet("telefono:--"));
        LatLng gimnasios81= new LatLng(13.4821151321315,-88.181135671487);
        mMap.addMarker(new MarkerOptions().position(gimnasios81).title("Gimnasio Femenino Paola").snippet("telefono:--"));
        LatLng gimnasios82= new LatLng(13.4876198553998,-88.1663029896309);
        mMap.addMarker(new MarkerOptions().position(gimnasios82).title("LIONS GYM").snippet("telefono:7570-3547"));
        LatLng gimnasios83= new LatLng(13.4882469677245,-88.1703156958335);
        mMap.addMarker(new MarkerOptions().position(gimnasios83).title("Adlery Gym").snippet("telefono:--"));
        LatLng gimnasios84= new LatLng(13.4877940534329,-88.1898059831033);
        mMap.addMarker(new MarkerOptions().position(gimnasios84).title("Iron Gym").snippet("telefono:--"));
        LatLng gimnasios85= new LatLng(13.4963012837341,-88.1726656418905);
        mMap.addMarker(new MarkerOptions().position(gimnasios85).title("Blij's Gym").snippet("telefono:7581-5786"));
        LatLng gimnasios86= new LatLng(13.8767487,-88.6277348);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gimnasios,15));
    }
}
