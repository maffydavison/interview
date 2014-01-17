package com.maffy.example.model;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: maryannfinnerty
 * Date: 11/11/13
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionReader {

    private int totalTransactions;
    private Map<String, Integer> mapTransactionsByStore;

    public TransactionReader() {
        totalTransactions = 0;
        mapTransactionsByStore = new HashMap<String, Integer>();
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public Map<String, Integer> getMapTransactionsByStore() {
        return mapTransactionsByStore;
    }

    public int getTransactionCountByStore(String storeId) {
        return mapTransactionsByStore.get(storeId);
    }

    @SuppressWarnings("unchecked")
    public void readPOSFile(String fileName) {
        // TODO: write a method to read the XML file fileName
        SAXBuilder saxBuilder = new SAXBuilder();
        // 1. When reading the file, keep track of the number
        //    of transactions per store
        // 2. Assume the file is 4GB uncompressed and contains
        //    records for 1000 stores for one day only
        try {

            Document document = saxBuilder.build(new File(fileName));
            Element rootNode = document.getRootElement();
            List transactionList = rootNode.getChildren("transaction");

            for(int i=0;i<=transactionList.size()-1;i++){
                Element element = (Element) transactionList.get(i);

                totalTransactions++;
                if (mapTransactionsByStore.containsKey(element.getChildText("store_id"))) {
                    int temp = mapTransactionsByStore.get(element.getChildText("store_id"));
                    mapTransactionsByStore.put(element.getChildText("store_id"), ++temp);
                } else {
                    mapTransactionsByStore.put(element.getChildText("store_id"), 1);
                }
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TransactionReader reader = new TransactionReader();
        reader.readPOSFile("/Users/maryannfinnerty/ideaGit/example/src/main/java/com/maffy/example/model/transactions.xml");

        // TODO: print the total number of transactions in the file
        System.out.println("Total number of transactions in the file: " + reader.getTotalTransactions());
        // TODO: print the total number of transactions for each
        Map<String, Integer> map = reader.getMapTransactionsByStore();
        for (String store : map.keySet()) {
            System.out.println("Store " + store + " had " + reader.getTransactionCountByStore(store) + " transactions.");
        }
    }


}
