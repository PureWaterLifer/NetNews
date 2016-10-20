package com.zzptc.sky.netnews;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DaoAutoGenerator {

    private final Schema schema;

    public static void main(String[] args) throws Exception {
        DaoAutoGenerator daoAutoGenerator = new DaoAutoGenerator();
        daoAutoGenerator.generator();
    }


    public DaoAutoGenerator(){
        schema = new Schema(1,"com.zzptc.sky.netnews.greendao");

        createNewsChannelTable();
    }

    private void createNewsChannelTable(){
        Entity newsChannelTable = schema.addEntity("NewsChannelTable");

        newsChannelTable.addStringProperty("newsChannelName").notNull().primaryKey();
        newsChannelTable.addStringProperty("newsChannelId").notNull();
        newsChannelTable.addStringProperty("newsChannelType").notNull();
        newsChannelTable.addBooleanProperty("newsChannelSelect").notNull();
        newsChannelTable.addIntProperty("newsChannelIndex").notNull();
        newsChannelTable.addBooleanProperty("newsChannelFixed").notNull();
    }

    private void generator() throws Exception {
        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.generateAll(schema,"./netnews/src/main/java");
    }

}
