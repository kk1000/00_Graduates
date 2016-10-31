package com.xpple.graduates.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ktplay.open.KTUser;
import com.xpple.graduates.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LazyAdapter extends BaseListAdapter<KTUser> {
    private ImageView header;
    private String imageUrl;

    public LazyAdapter(Context context, List<KTUser> items) {
        super(context, items);
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
        }
        KTUser contract = getList().get(position);
        TextView score = ViewHolder.get(convertView, R.id.score);
        TextView city = ViewHolder.get(convertView, R.id.city);
        TextView nick = ViewHolder.get(convertView, R.id.nick);
        TextView gender = ViewHolder.get(convertView, R.id.gender);
        TextView rank = ViewHolder.get(convertView, R.id.rank);
        header = ViewHolder.get(convertView, R.id.header);

        score.setText("总分:" + contract.getScore());
        city.setText(contract.getCity());
        nick.setText("ID:" + contract.getNickname());
        gender.setText((contract.getGender() == 1) ? "（男）" : "（女）");
        rank.setText("第" + String.valueOf(contract.getRank()) + "名");

        GetImage getImage = new GetImage();
        imageUrl = contract.getHeaderUrl() + "_50x50";
        getImage.execute(imageUrl);
        return convertView;
    }

    private class GetImage extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL webImage = new URL(imageUrl);
                HttpURLConnection conn = (HttpURLConnection) webImage.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            header.setImageBitmap(result);
        }
    }
}

