//package com.forrestgump.myapplication;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class UserListFragment extends Fragment {
//
//    private RecyclerView recyclerView;
//    private UserAdapter adapter;
//    private List<User> userList;
//    private AppDatabase db;
//    private ExecutorService executor;
//    private Button buttonAddUser;
//
//    public UserListFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_user_list, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        db = AppDatabase.getInstance(getContext());
//        executor = Executors.newSingleThreadExecutor();
//
//        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        userList = new ArrayList<>();
//        adapter = new UserAdapter(userList, this::openUserDetailFragment);
//        recyclerView.setAdapter(adapter);
//
//        executor.execute(() -> {
//            List<User> users = db.userDao().getAllUsers();
//            userList.addAll(users);
//            getActivity().runOnUiThread(() -> adapter.notifyDataSetChanged());
//        });
//
//        buttonAddUser = view.findViewById(R.id.buttonAddUser);
//        buttonAddUser.setOnClickListener(v -> openUserCreateFragment());
//    }
//
//    private void openUserDetailFragment(User user) {
//        UserDetailFragment fragment = new UserDetailFragment();
//        Bundle args = new Bundle();
//        args.putSerializable("user", user);
//        fragment.setArguments(args);
//
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
//
//    private void openUserCreateFragment() {
//        UserCreateFragment fragment = new UserCreateFragment();
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
//}
