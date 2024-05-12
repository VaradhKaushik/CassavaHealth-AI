# CassavaHealth-AI

## Overview
CassavaHealth AI is a machine learning project focused on improving cassava plant health by accurately diagnosing various leaf diseases. Built using a "One-vs-All" methodology and EfficientNet B4, this solution not only boosts detection accuracy but is also accessible through an Android application, making it a valuable tool for farmers globally.

## Features
- **Advanced CNNs**: Utilizes EfficientNet B4 for robust image classification.
- **Binary Classifiers**: Incorporates a "One-vs-All" strategy for detailed disease analysis.
- **Android Integration**: Mobile application available for practical, field-level usage.
- **High Accuracy**: Proven effectiveness on skewed real-world data, reflecting typical agricultural scenarios.

## Getting Started
To get a local copy up and running follow these simple steps:

### Prerequisites
- Python 3.8+
- pip
- Git

### Installation
```bash
# Clone the repo
git clone https://github.com/VaradhKaushik/CassavaHealth-AI.git

# Navigate to the project directory
cd CassavaHealth-AI

# Install required packages
pip install -r requirements.txt
```

### Usage
## Mobile Application
Download the APK, install it on your Android device, and follow the on-screen instructions to analyze cassava leaf images directly.

### How It Works
CassavaHealth AI trains on a dataset of cassava leaf images, where each image undergoes preprocessing and augmentation before classification. Each of the five diseases has a dedicated binary classifier, ensuring high precision and reliability.





