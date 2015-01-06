package com.humoule.recycleviewsample;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{

	private List<Contact> contactList;

	public ContactAdapter(List<Contact> contactList) {
		this.contactList = contactList;
	}

	@Override
	public int getItemCount()
	{
		return contactList.size();
	}

	@Override
	public void onBindViewHolder(ContactViewHolder contactViewHolder, int i)
	{
		Contact contact = contactList.get(i);
		contactViewHolder.nameTxtView.setText(contact.name);
		contactViewHolder.FirstNameTxtView.setText(contact.firstName);
		contactViewHolder.emailTxtView.setText(contact.email);
		contactViewHolder.titleTextView.setText(contact.name + " " + contact.firstName);
	}

	@Override
	public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
	{
		View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);

		return new ContactViewHolder(itemView);
	}

	public static class ContactViewHolder extends RecyclerView.ViewHolder
	{

		protected TextView nameTxtView;
		protected TextView FirstNameTxtView;
		protected TextView emailTxtView;
		protected TextView titleTextView;

		public ContactViewHolder(View v) {
			super(v);
			nameTxtView = (TextView) v.findViewById(R.id.txtName);
			FirstNameTxtView = (TextView) v.findViewById(R.id.txtSurname);
			emailTxtView = (TextView) v.findViewById(R.id.txtEmail);
			titleTextView = (TextView) v.findViewById(R.id.title);
		}
	}
}
