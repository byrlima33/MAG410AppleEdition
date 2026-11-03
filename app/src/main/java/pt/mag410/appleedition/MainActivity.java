package pt.mag410.appleedition;
import android.app.Activity; import android.os.Bundle; import android.content.Intent; import android.graphics.Color; import android.graphics.drawable.GradientDrawable; import android.view.*; import android.widget.*;
public class MainActivity extends Activity {
 String[] names={"Televisão","YouTube","Filmes","Música","Multimédia","Definições"};
 String[] pkgs={"com.gsetech.smartiptv","com.google.android.youtube.tv","com.mxtech.videoplayer.ad",null,null,null};
 String[] icons={"▣","▶","▤","♫","▧","⚙"};
 int dp(int n){return (int)(n*getResources().getDisplayMetrics().density+.5f);}
 TextView label(String s,int size,int color,boolean bold){TextView t=new TextView(this);t.setText(s);t.setTextSize(size);t.setTextColor(color);if(bold)t.setTypeface(null,1);return t;}
 public void onCreate(Bundle b){super.onCreate(b);getWindow().getDecorView().setSystemUiVisibility(5894|1024|512);setContentView(screen());}
 View screen(){
 LinearLayout page=new LinearLayout(this);page.setOrientation(1);page.setPadding(dp(30),dp(18),dp(30),dp(14));page.setBackgroundColor(Color.rgb(8,10,14));
 page.addView(label("MAG410   /   APPLE EDITION",21,Color.WHITE,true),new LinearLayout.LayoutParams(-1,dp(42)));
 LinearLayout hero=new LinearLayout(this);hero.setGravity(Gravity.CENTER_VERTICAL);hero.setOrientation(1);hero.setPadding(dp(25),dp(15),dp(20),dp(15));
 GradientDrawable hb=new GradientDrawable(GradientDrawable.Orientation.TL_BR,new int[]{0xff42536a,0xff1c2938,0xff101318});hb.setCornerRadius(dp(18));hero.setBackground(hb);
 hero.addView(label("EM DESTAQUE",13,0xffc3ccd8,true));hero.addView(label("O teu cinema.\nÀ tua maneira.",30,Color.WHITE,true));hero.addView(label("Entretenimento, televisão e multimédia num único lugar.",15,0xffc0c5ce,false));
 LinearLayout.LayoutParams hp=new LinearLayout.LayoutParams(-1,0,1);hp.setMargins(0,dp(10),0,dp(14));page.addView(hero,hp);
 page.addView(label("As tuas aplicações",19,Color.WHITE,true));
 LinearLayout row=new LinearLayout(this);row.setPadding(0,dp(8),0,0);
 for(int n=0;n<names.length;n++){final int ix=n;LinearLayout tile=new LinearLayout(this);tile.setOrientation(1);tile.setGravity(Gravity.CENTER);tile.setFocusable(true);tile.setFocusableInTouchMode(true);
 GradientDrawable bg=new GradientDrawable();bg.setColor(0xff222832);bg.setCornerRadius(dp(13));tile.setBackground(bg);
 TextView ic=label(icons[n],32,n==1?0xffff3333:Color.WHITE,true);ic.setGravity(Gravity.CENTER);tile.addView(ic,new LinearLayout.LayoutParams(-1,dp(48)));
 TextView tx=label(names[n],13,Color.WHITE,false);tx.setGravity(Gravity.CENTER);tile.addView(tx);
 tile.setOnFocusChangeListener((v,f)->{GradientDrawable d=new GradientDrawable();d.setColor(f?0xff435064:0xff222832);d.setCornerRadius(dp(13));if(f)d.setStroke(dp(2),0xfff0f4ff);v.setBackground(d);v.setScaleX(f?1.04f:1);v.setScaleY(f?1.04f:1);});
 tile.setOnClickListener(v->open(ix));LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(0,dp(105),1);lp.setMargins(dp(4),0,dp(4),0);row.addView(tile,lp);}
 page.addView(row);TextView foot=label("MAG410  •  Android 6.0.1                         A tua box, ainda melhor.",12,0xff9da6b2,false);LinearLayout.LayoutParams fp=new LinearLayout.LayoutParams(-1,dp(30));fp.topMargin=dp(10);page.addView(foot,fp);
 row.getChildAt(0).requestFocus();return page;
 }
 void open(int n){try{if(n<3){Intent i=getPackageManager().getLaunchIntentForPackage(pkgs[n]);if(i!=null){startActivity(i);return;}}else if(n==5){startActivity(new Intent("android.settings.SETTINGS"));return;}else if(n==4){Intent i=new Intent(Intent.ACTION_GET_CONTENT);i.setType("image/*");startActivity(i);return;}Toast.makeText(this,"Esta secção será configurada na próxima versão.",0).show();}catch(Exception e){Toast.makeText(this,"Aplicação indisponível: "+names[n],0).show();}}
}
