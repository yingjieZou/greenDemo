/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class ExampleDaoGenerator {
	private static final String PACKAGE_DAO = "com.green.study.db";
	private static final String PACKAGE_BEAN = "com.green.study.bean";

    public static void main(String[] args) throws Exception {
    	 Schema schema = new Schema(1, "com.green.study.db");
    	 schema.enableKeepSectionsByDefault();
    	 //调用方法创建Entity和DAO，在有新的实体类需要创建只需要新建一个方法进行类似的创建操作即可
    	 addUserInfo(schema);
         new DaoGenerator().generateAll(schema, "../greenDemo/src");
    }	
    
    public static void addUserInfo(Schema schema){
    	//添加实体类
    	Entity userInfo = schema.addEntity("UserInfo");
    	//为实体类设置属性
    	userInfo.addStringProperty("userName").notNull();
    	userInfo.addStringProperty("userPassword").notNull();
    	userInfo.addStringProperty("userId").notNull().primaryKey();
    	userInfo.addStringProperty("userAddress");
    	
    	//设置实体类的包名路径
    	userInfo.setJavaPackage(PACKAGE_BEAN);
    	//设置DAO类的包名路径
    	userInfo.setJavaPackageDao(PACKAGE_DAO);
    }
}
