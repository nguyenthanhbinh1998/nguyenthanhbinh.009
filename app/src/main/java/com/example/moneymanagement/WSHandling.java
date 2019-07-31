package com.example.moneymanagement;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class WSHandling extends AsyncTask<String,Void,ArrayList> {


    // URL
    String URL_DISP = "http://192.168.1.16:8080/ws/display.php";
    String URL_CREATE = "http://192.168.1.16:8080/ws/create.php";
    String URL_UPDATE = "http://192.168.1.16:8080/ws/update.php";
    String URL_DELETE = "http://192.168.1.16:8080/ws/delete.php";

    ProgressDialog pDialog;
    ListView lvAccounts;

    static final String DISPLAY = "display";
    static final String CREATE = "create";
    static final String UPDATE = "update";
    static final String DELETE = "delete";

    String acc_user;
    String acc_pwd;
    ServiceHandling sh = new ServiceHandling();

    Context context;
    ArrayList<Accounts> al;

    public WSHandling(Context context, ListView lvAccounts){
        this.context = context;
        this.lvAccounts = lvAccounts;
    }

    public WSHandling(Context context, String acc_user, String acc_pwd) {
        this.context = context;
        this.acc_user = acc_user;
        this.acc_pwd = acc_pwd;
    }

    @Override
    protected ArrayList doInBackground(String... params) {
        switch (params[0]) {
            case DISPLAY:
                al = new ArrayList<>();
                String json = sh.call(URL_DISP, ServiceHandling.GET, null);
                if (json != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(json);
                        if (jsonObj != null) {
                            JSONArray accounts = jsonObj.getJSONArray("accounts");

                            for (int i = 0; i < accounts.length(); i++) {
                                JSONObject obj = (JSONObject) accounts.get(i);
                                Accounts acc = new Accounts(obj.getString("acc_user"), obj.getString("acc_pwd"));
                                al.add(acc);
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.e("JSON Data", "Didn't receive any data from server!");
                }
                break;
            case CREATE:
                // Tạo danh sách tham số gửi đến máy chủ
                List<NameValuePair> args = new ArrayList<NameValuePair>();
                args.add(new BasicNameValuePair("acc_user", acc_user));
                args.add(new BasicNameValuePair("acc_pwd", acc_pwd));

                // Lấy đối tượng JSON
                json = sh.call(URL_CREATE, ServiceHandling.POST, args);
                if (json != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        int success = jsonObject.getInt("success");
                        if (success == 1) {

                        } else {

                        }
                    } catch (JSONException e) {
                        Log.d("Error...", e.toString());
                    }
                }
                break;
            case UPDATE:
                // Tạo danh sách tham số gửi đến máy chủ
                args = new ArrayList<NameValuePair>();
                args.add(new BasicNameValuePair("acc_user", acc_user));
                args.add(new BasicNameValuePair("acc_pwd", acc_pwd));

                // Lấy đối tượng JSON
                json = sh.call(URL_UPDATE, ServiceHandling.POST, args);
                if (json != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        int success = jsonObject.getInt("success");
                        if (success == 1) {

                        } else {

                        }
                    } catch (JSONException e) {
                        Log.d("Error...", e.toString());
                    }
                }
                break;
            case DELETE:
                // Tạo danh sách tham số gửi đến máy chủ
                args = new ArrayList<NameValuePair>();
                args.add(new BasicNameValuePair("acc_user", acc_user));
                args.add(new BasicNameValuePair("acc_pwd", acc_pwd));

                // Lấy đối tượng JSON
                json = sh.call(URL_DELETE, ServiceHandling.POST, args);
                if (json != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        int success = jsonObject.getInt("success");
                        if (success == 1) {

                        } else {

                        }
                    } catch (JSONException e) {
                        Log.d("Error...", e.toString());
                    }
                }
                break;
        }
        return al;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Proccesing..");
        pDialog.setCancelable(false);
        pDialog.show();

    }

    @Override
    protected void onPostExecute(ArrayList ret) {
        super.onPostExecute(ret);

        if (pDialog.isShowing())
            pDialog.dismiss();
        loadData();
    }

    private void loadData() {
        if (al == null) {
            return;
        }

        List<String> data = new ArrayList<String>();

        for (int i = 0; i < al.size(); i++) {
            Accounts acc = al.get(i);
            data.add(acc.acc_user + ": " + acc.acc_pwd);
        }
        // Tạo adapter cho listivew
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, data);

        // Gắn adapter cho listview
        lvAccounts.setAdapter(adapter);
    }

    public ArrayList<Accounts> getData() {
        return al;
    }
}
