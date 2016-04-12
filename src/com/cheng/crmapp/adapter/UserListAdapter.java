package com.cheng.crmapp.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.model.UserModel;
import com.cheng.crmapp.util.MyDebug;

@SuppressWarnings("rawtypes")
public class UserListAdapter extends RecyclerView.Adapter {

	private List<UserModel> list = new ArrayList<UserModel>();
	private Context context = null;
	private boolean isSectionSupport = false;
	private OnItemClickEventListener listener = null;

	public interface OnItemClickEventListener {

		void onItemClick(int position);

		void onItemLongClick(int position);
	}

	public void setOnItemClickEventListener(OnItemClickEventListener listener) {

		this.listener = listener;
	}

	public UserListAdapter(Context context) {

		this.context = context;
		this.isSectionSupport = false;
	}

	/**
	 * @param isSectionSupport
	 *            是否支持item分类
	 */
	public UserListAdapter(Context context, boolean isSectionSupport) {

		this.context = context;
		this.isSectionSupport = isSectionSupport;
	}

	public void setAdapterData(List<UserModel> data) {
		this.list = data;

	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		RelativeLayout layout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_user_list, null);

		return new MyViewHolder(layout, listener);
	}

	// 判断消息是否可以到达--是否可联系
	// public boolean isReachable(int position) {
	//
	// long lastTime = list.get(position).last_time;
	// long curTime = System.currentTimeMillis() / 1000;
	//
	// if (lastTime > 0 && curTime - lastTime < 48 * 3600) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

		MyViewHolder mholder = (MyViewHolder) holder;
		mholder.name.setText(list.get(position).nickname);
		
		if (isSectionSupport) {// 联系人列表需要支持section 分类
			mholder.divider1.setVisibility(View.GONE);
			String pinyin = list.get(position).nickname_py;

			int section = getSectionForPosition(position, pinyin);

			if (position == getPositionForSection(section)) {
				mholder.divider.setVisibility(View.GONE);
				mholder.sectionLayout.setVisibility(View.VISIBLE);
				mholder.sectionTitle.setText(pinyin.toUpperCase().charAt(0) + "");
			} else {
				mholder.sectionLayout.setVisibility(View.GONE);
				mholder.divider.setVisibility(View.VISIBLE);
			}
		}

	}

	@Override
	public int getItemCount() {
		return null == list ? 0 : list.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {

		public ImageView avatar = null;
		public TextView name = null;
		public ImageView userState = null;
		public LinearLayout sectionLayout = null;
		public TextView sectionTitle = null;
		public View divider = null;
		public View divider1 = null;

		public MyViewHolder(View itemView, final OnItemClickEventListener lis) {
			super(itemView);

			name = (TextView) itemView.findViewById(R.id.name);
			sectionLayout = (LinearLayout) itemView.findViewById(R.id.section);
			sectionTitle = (TextView) itemView.findViewById(R.id.index);
			divider = itemView.findViewById(R.id.divider);
			divider1 = itemView.findViewById(R.id.divider1);
			// 设置点击监听
			if (null != lis) {

				itemView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						lis.onItemClick(getAdapterPosition());

					}
				});

				itemView.setOnLongClickListener(new View.OnLongClickListener() {
					@Override
					public boolean onLongClick(View v) {

						lis.onItemLongClick(getAdapterPosition());

						return true;
					}
				});

			}

		}
	}

	/**
	 * 获取分类标题
	 *
	 * @param section
	 * @return
	 */

	public int getPositionForSection(int section) {
		for (int i = 0; i < getItemCount(); i++) {

			String pinyin = list.get(i).nickname_py;

			char firstChar = pinyin.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}

		return -1;
	}

	public int getSectionForPosition(int position, String pinyin) {

		return pinyin.toUpperCase().charAt(0);
	}

}
