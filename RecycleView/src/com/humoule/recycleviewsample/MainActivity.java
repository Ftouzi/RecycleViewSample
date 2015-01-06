package com.humoule.recycleviewsample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends Activity
{

	private final static String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RecyclerView recycleList = (RecyclerView) findViewById(R.id.cardList);
		recycleList.setHasFixedSize(true);

		/**
		 * RecyclerView requires a layout manager. This component positions item views inside the row and determines
		 * when it is time to recycle the views. The library provides a default layout manager called
		 * LinearLayoutManager
		 */
		LinearLayoutManager llm = new LinearLayoutManager(this);
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		recycleList.setLayoutManager(llm);

		ContactAdapter contactAdapter = new ContactAdapter(createList(10));
		recycleList.setAdapter(contactAdapter);
	}

	/**
	 * Create contacts list
	 * 
	 * @param size
	 * @return
	 */
	private List<Contact> createList(int size)
	{

		List<Contact> result = new ArrayList<Contact>();
		for (int i = 1; i <= size; i++)
		{
			Contact contact = new Contact();
			contact.name = Contact.NAME_PREFIX + i;
			contact.firstName = Contact.FIRSTNAME_PREFIX + i;
			contact.email = Contact.EMAIL_PREFIX + i + "@test.com";

			result.add(contact);

		}

		return result;
	}
}
