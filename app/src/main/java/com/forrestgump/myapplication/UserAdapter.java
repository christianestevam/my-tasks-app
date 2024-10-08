//package com.forrestgump.myapplication;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//
//    private List<User> userList;
//    private OnUserClickListener onUserClickListener;
//
//    public UserAdapter(List<User> userList, OnUserClickListener onUserClickListener) {
//        this.userList = userList;
//        this.onUserClickListener = onUserClickListener;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.recycler_item_task, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        User user = userList.get(position);
//        holder.textViewItem.setText(user.getName() + " - " + user.getCity() + " - " + user.getFavoriteFood());
//        holder.itemView.setOnClickListener(v -> onUserClickListener.onUserClick(user));
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    public static class UserViewHolder extends RecyclerView.ViewHolder {
//        TextView textViewItem;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textViewItem = itemView.findViewById(R.id.textViewItem);
//        }
//    }
//
//    public interface OnUserClickListener {
//        void onUserClick(User user);
//    }
//}
