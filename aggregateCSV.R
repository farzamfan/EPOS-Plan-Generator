args = commandArgs(trailingOnly=TRUE)
userFiles <- list.files(paste(args,"detailedCSV/",sep = ""))
p <- 1
q <- 1
for(i in 1:(length(userFiles))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles <- list.files(paste(paste(args,"detailedCSV/",sep = ""),userFiles[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles[1],sep = ","))
  for(j in 2:length(planFiles)){
    newData <- data.frame(read.csv(planFiles[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  dir.create(paste(args,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args,"detailedCSV/",sep = ""),userFiles[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}


