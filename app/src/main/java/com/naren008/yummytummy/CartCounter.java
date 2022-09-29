package com.naren008.yummytummy;

import android.content.Context;
import android.database.Cursor;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class CartCounter {

     Context context;

     public CartCounter(Context context) {
          this.context = context;
     }

     public int cartCount(){
          int count = 0;
          EasyDB easyDB = EasyDB.init(context, "product")
                  .setTableName("ITEM TABLE")
                  .addColumn(new Column("item_id", "text", "unique"))
                  .addColumn(new Column("item_name", "text","not null"))
                  .addColumn(new Column("item_price", "text","not null"))
                  .addColumn(new Column("item_image", "text","not null"))
                  .doneTableColumn();

          Cursor res = easyDB.getAllData();
          while(res.moveToNext()){
               count++;
          }
          return count;
     }
}
