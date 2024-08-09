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
//public class UserCreateFragment extends Fragment {
//
//    private EditText editTextName, editTextCity, editTextFavoriteFood;
//    private Button buttonAdd;
//    private AppDatabase db;
//    private ExecutorService executor;
//
//    public UserCreateFragment() {
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_user_create, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        db = AppDatabase.getInstance(getContext());
//        executor = Executors.newSingleThreadExecutor();
//
//        editTextName = view.findViewById(R.id.editTextName);
//        editTextCity = view.findViewById(R.id.editTextCity);
//        editTextFavoriteFood = view.findViewById(R.id.editTextFavoriteFood);
//        buttonAdd = view.findViewById(R.id.buttonAdd);
//
//        buttonAdd.setOnClickListener(v -> {
//            String name = editTextName.getText().toString();
//            String city = editTextCity.getText().toString();
//            String favoriteFood = editTextFavoriteFood.getText().toString();
//
//            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(city) || TextUtils.isEmpty(favoriteFood)) {
//                Toast.makeText(getContext(), "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            User user = new User(name, city, favoriteFood);
//
//            executor.execute(() -> {
//                db.userDao().insert(user);
//                getActivity().runOnUiThread(() -> {
//                    Toast.makeText(getContext(), "Usuário adicionado", Toast.LENGTH_SHORT).show();
//                    // Limpa os campos após adicionar o usuário
//                    editTextName.setText("");
//                    editTextCity.setText("");
//                    editTextFavoriteFood.setText("");
//                    // Navegar de volta para a lista de usuários
//                    getActivity().getSupportFragmentManager().popBackStack();
//                });
//            });
//        });
//    }
//}
