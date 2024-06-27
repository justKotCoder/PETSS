import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pets.Presentation.screens.General._BottomBar
import com.example.pets.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5F6FF)) // Light blue background
            .padding(16.dp)
    ) {
        UserInfoSection()
        Spacer(modifier = Modifier.height(16.dp))
        MenuButton(text = "Избранное")
        MenuButton(text = "Мои заказы")
        MenuButton(text = "Способы оплаты")
        MenuButton(text = "Помощь")
        Spacer(modifier = Modifier.weight(1f))
        LogoutButton()
    }
}

@Composable
fun UserInfoSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFF339AFE), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_profil),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Иванов Иван", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "pochta@gmail.com", color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.notification),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(35.dp)
        )

    }
}

@Composable
fun MenuButton(text: String) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        contentPadding = PaddingValues(0.dp) // Устанавливаем нулевой внутренний отступ
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF003A61),
            modifier = Modifier
                .align(Alignment.CenterVertically) // Центрируем текст по вертикали
                .padding(start = 16.dp) // Добавляем отступ слева
        )
    }
}

@Composable
fun LogoutButton() {
    Button(
        onClick = { /* Handle logout */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF339AFE)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "Выйти", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun ProfileScreenWithBottomBar() {
    val navController = rememberNavController()

//    Scaffold(
//        bottomBar = {
//            BottomNavigation {
//                // Define your bottom navigation items here
//            }
//        }
//    ) { innerPadding ->
        //   Box(modifier = Modifier.padding(innerPadding)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE5F6FF))
        ) {
            ProfileScreen()
        }
    }
//}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreenWithBottomBar()
}
