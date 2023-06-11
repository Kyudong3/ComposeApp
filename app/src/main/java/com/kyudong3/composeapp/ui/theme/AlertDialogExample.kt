package com.kyudong3.composeapp.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ConfirmDialogLight() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "확인")
            }
        },
        dismissButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "취소")
            }
        },
        title = {
            Row(
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(text = "제목")
            }
        },
        text = {
            Text(text = "내용")
        }
    )
}

@Composable
fun ConfirmDialogDark() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "확인")
            }
        },
        dismissButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "취소")
            }
        },
        title = {
            Row(
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(text = "제목")
            }
        },
        text = {
            Text(text = "내용")
        },
    )
}

/**
 * 기본적으로 Theme에서 12버전 이상에서는 dynamicColor가 적용되기 때문에 배경등이 light, dark 모두 정의되어
 * 있는 색상으로 나오게 된다.
 * Theme의 dynamicColor와 colorScheme을 살펴보자.
 *
 * 프리뷰에서 dynamic Color를 false로 바꾸면 원하는 색상이 잘 적용되었는지 확인할 수 있다
 */
@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ConfirmDialogLightPreview() {
    ComposeAppTheme(dynamicColor = false) {
        ConfirmDialogLight()
    }
}