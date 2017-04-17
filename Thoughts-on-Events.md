
# Interagency data relation

## Propose
Use Frequency as Target feature,

Catagory as Agency

## Process
### Per Agency
0. Frequency = count / (month, week, day, hour, min, second)
1. Direct Plot =  Frequency~t
2. Trend = Linear regress (Direct Plot )
3. Seasonality = Sine Cosine regress (Direct Plot )
4. Noise = Direct Plot/ (Trend * Seasonality)
5. Irregularity = outliers in Noise

### Inter Agency
6. Correlation = correlation (time of Irregularity per Agency ) (edited)
7. Causation = if time latency (Correlation)

## Limit
Does not count any spatial data or feature other than temporal 

# Generalize Idea

## Propose
Use `Feature` as Target feature,

Catagory as `Catagory`

## Process
### Per `Catagory`
0. Stats = cumulative/mean `Feature` / (month, week, day, hour, min, second)
1. Direct Plot =  Stats~t
2. Trend = Linear regress (Direct Plot )
3. Seasonality = Sine Cosine regress (Direct Plot )
4. Noise = Direct Plot/ (Trend * Seasonality)
5. Irregularity = outliers in Noise

### Inter `Catagory`
6. Correlation = correlation (time of Irregularity per Agency ) (edited)
7. Causation = if time latency (Correlation)

