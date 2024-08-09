//package com.forrestgump.myapplication;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class UserDetailFragment extends Fragment {
//
//    private EditText editTextName, editTextCity, editTextFavoriteFood;
//    private Button buttonUpdate, buttonDelete;
//    private AppDatabase db;
//    private ExecutorService executor;
//    private User user;
//
//    public UserDetailFragment() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_user_details, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        db = AppDatabase.getInstance(getContext());
//        executor = Executors.newSingleThreadExecutor();
//
//        editTextName = view.findViewById(R.id.editTextName);
//        editTextCity = view.findViewById(R.id.editTextCity);
//        editTextFavoriteFood = view.findViewById(R.id.editTextFavoriteFood);
//        buttonUpdate = view.findViewById(R.id.buttonUpdate);
//        buttonDelete = view.findViewById(R.id.buttonDelete);
//
//        if (getArguments() != null) {
//            user = (User) getArguments().getSerializable("user");
//            if (user != null) {
//                editTextName.setText(user.getName());
//                editTextCity.setText(user.getCity());
//                editTextFavoriteFood.setText(user.getFavoriteFood());
//            }
//        }
//
//        buttonUpdate.setOnClickListener(v -> updateUser());
//
//        buttonDelete.setOnClickListener(v -> deleteUser());
//    }
//
//    private void updateUser() {
//        String name = editTextName.getText().toString();
//        String city = editTextCity.getText().toString();
//        String favoriteFood = editTextFavoriteFood.getText().toString();
//
//        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(city) || TextUtils.isEmpty(favoriteFood)) {
//            Toast.makeText(getContext(), "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        user.setName(name);
//        user.setCity(city);
//        user.setFavoriteFood(favoriteFood);
//
//        executor.execute(() -> {
//            db.userDao().update(user);
//            getActivity().runOnUiThread(() -> {
//                Toast.makeText(getContext(), "Usuário atualizado", Toast.LENGTH_SHORT).show();
//                // Navegar de volta ou atualizar a lista principal
//            });
//        });
//    }
//
//    private void deleteUser() {
//        executor.execute(() -> {
//            db.userDao().delete(user);
//            getActivity().runOnUiThread(() -> {
//                Toast.makeText(getContext(), "Usuário excluído", Toast.LENGTH_SHORT).show();
//            });
//        });
//    }
//}
