header <- read.csv("data/header.csv", header=T)
header <- colnames(header)

path.to.files <- "data/Agency"
files <- list.files(path=path.to.files, pattern="*.csv", full.names=F, recursive=FALSE)

lapply(files, function(x) {
  csv <- read.csv(paste0(path.to.files,"/",x), header=F) # load file
  colnames(csv) <- header
  summary.t <- summary(csv)
  
  write.csv(summary.t, paste0("data/Agency-Summary/",x))
})
