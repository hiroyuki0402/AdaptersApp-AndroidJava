package com.example.adaptersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> shiraishis;

    public CustomListAdapter(Context context, ArrayList<String> items) {
        this.context = context;
                this.shiraishis = items;
    }

    // このメソッドは、ListViewに表示されるアイテムの総数を返す
    @Override
    public int getCount() {
        return shiraishis.size();
    }
    // このメソッドは、指定された位置のアイテムを返す。
    @Override
    public Object getItem(int position) {
        return shiraishis.get(position);
    }
    // このメソッドは、指定された位置のアイテムのIDを返す。
    // 通常、位置自体がIDとして使用される
    @Override
    public long getItemId(int position) {
        return position;
    }
    // このメソッドは、指定された位置のビューを返しす。
    // 再利用可能なビューを使用して効率的に動作すr
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // convertViewは再利用可能なビュー
        // nullの場合、新しいビューを作成する
        if (convertView == null) {
            // LayoutInflaterを使用して新しいビューを作成する
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_custom_adapter, parent, false);

            holder = new ViewHolder();
            holder.textView4 = convertView.findViewById(R.id.textView4);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // convertViewからテキストビューを取得し、アイテムのデータを設定
        holder.textView4.setText(shiraishis.get(position));
        // 完成したビューを返す。(return cellみたいな感じ)
        return convertView;
    }

    static class ViewHolder{
        // Holds references to the views within an item layout
        TextView textView4;

    }
};



/*　swiftに例えると

// Java: private class CustomListAdapter extends BaseAdapter {
class CustomListAdapter: UITableViewDataSource {

    // Java: public int getCount() { return shiraishis.size(); }
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // このメソッドは、セクション内の行数を返しJavaのgetCount()に相当
        return shiraishis.count
    }

    // JavaのgetItem(int position)やgetItemId(int position)は、SwiftのUITableViewDataSourceには直接相当するメソッドはないようだ
    // しかし、cellForRowAtのindexPath.rowがpositionに相当

    // Java: public View getView(int position, View convertView, ViewGroup parent) {
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // このメソッドは、指定された位置にあるセルを返しJavaのgetView()に相当する

        // Java: if (convertView == null) {...}
        let cell = tableView.dequeueReusableCell(withIdentifier: "CellIdentifier", for: indexPath)
        // dequeueReusableCellは、再利用可能なセルを返すメソッドでセルが再利用キューにない場合、新しいセルが自動的に作成される

        // Java: TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        // Java: textView.setText(shiraishis.get(position));
        let data = shiraishis[indexPath.row] // indexPath.rowがJavaのpositionに相当する
        cell.textLabel?.text = data

        return cell
    }
}
 */
