# GDELT-GlobalEventAnalyzer

## Overview
GDELT-GlobalEventAnalyzer is a Big Data processing application that leverages Hadoop MapReduce to analyze global events data from the GDELT (Global Database of Events, Language, and Tone) Project. This tool processes GDELT's event database to generate comprehensive statistics about event occurrences by country and event type.

## Features
- MapReduce-based processing for efficient large-scale data analysis
- Country-wise event aggregation
- Event type classification
- Scalable architecture for handling massive GDELT datasets
- Simple and clean output format for easy integration with other tools

## Technical Requirements
- Java 8 
- Apache Hadoop 2.x or higher
- Maven 3.x (for building)
- GDELT dataset access

## Project Structure
```
GDELT-GlobalEventAnalyzer/
├── src/
│   └── main/
│       └── java/
│           └── tn.insat.tp1/
│                       ├── GdeltEventMapper.java
│                       ├── GdeltEventReducer.java
│                       └── GdeltEventAnalysisRunner.java
├── pom.xml
├── README.md
└── .gitignore
```

## Installation
1. Clone the repository:
```bash
git clone https://github.com/yourusername/GDELT-GlobalEventAnalyzer.git
cd GDELT-GlobalEventAnalyzer
```

2. Build the project:
```bash
mvn clean package
```

## Usage
1. Ensure your Hadoop cluster is running (or start a single-node setup)
  [See](https://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/ClusterSetup.html)

3. Run the application:
```bash
hadoop jar target/gdelt-analyzer-1.0.jar tn.insat.tp1.GdeltEventAnalysisRunner \
    <input_path> <output_path>
```

### Input Format
The application expects GDELT data in its standard tab-separated format. Key fields used:
- Column 26: Event Code
- Column 51: Country Code

### Output Format
The output is generated in the following format:
```
COUNTRYCODE:EVENTCODE    COUNT
USA:14    126
FRA:20    89
...
```

## Data Processing
### Mapper Phase
- Parses GDELT's tab-separated input format
- Extracts country codes and event types
- Emits country-event pairs with initial count

### Reducer Phase
- Aggregates event counts for each country-event combination
- Generates final statistics

## Performance Considerations
- Utilizes Hadoop's distributed processing capabilities
- Implements combiners for improved efficiency
- Handles large-scale GDELT datasets effectively

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

## Future Enhancements
- [ ] Add temporal analysis capabilities
- [ ] Implement event type filtering
- [ ] Add geographical region aggregation
- [ ] Include sentiment analysis
- [ ] Develop visualization components

## Acknowledgments
- GDELT Project for providing the global events database
- Apache Hadoop community for the MapReduce framework

## Contact
For any queries regarding this project, please open an issue in the GitHub repository.
