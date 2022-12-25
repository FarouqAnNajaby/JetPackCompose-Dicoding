package com.example.submissioncomposedicoding.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.submissioncomposedicoding.R
import com.example.submissioncomposedicoding.di.Injection
import com.example.submissioncomposedicoding.ui.ViewModelFactory
import com.example.submissioncomposedicoding.ui.common.UiState
import com.example.submissioncomposedicoding.ui.theme.SubmissioncomposedicodingTheme

@Composable
fun DetailCountryScreen(
    id: Long,
    viewModel: DetailCountryViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getCountryById(id)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.photoUrl,
                    data.name,
                    data.desc,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    title: String,
    description: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                HeaderNavigation(image, modifier, onBackClick)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp),
            ) {
                DetailContent(title, description)
            }
        }
    }
}

@Composable
private fun DetailContent(title: String, description: String) {
    Text(
        text = title,
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.ExtraBold
        ),
    )
    Text(
        text = description,
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Light
        ),
    )
}

@Composable
private fun HeaderNavigation(
    image: Int,
    modifier: Modifier,
    onBackClick: () -> Unit
) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(40.dp)
            .clip(RoundedCornerShape(bottomStart = 20.dp))
    )
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = stringResource(R.string.back),
        modifier = Modifier
            .padding(16.dp)
            .clickable { onBackClick() }
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    SubmissioncomposedicodingTheme {
        DetailContent(
            R.drawable.france,
            "Croatia",
            "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit. " +
                    "Nullam finibus congue ante laoreet eleifend. Sed ipsum velit, " +
                    "dapibus nec laoreet.",
            onBackClick = {}
        )
    }
}