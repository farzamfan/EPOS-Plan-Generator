#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v10-JKettle/CloserToWorst-10/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[4],sep = ","))
  
  for(j in 1:3){
    dev <- data.frame(read.csv(planFiles1[j],sep = ","))[1,]
    dev[2:nrow(aggregate),] <- dev
    aggregate[,-1] <- aggregate[,-1] + dev[,-1]
  }
  
  for(j in 5:length(planFiles1)){
    dev <- data.frame(read.csv(planFiles1[j],sep = ","))[1,]
    dev[2:nrow(aggregate),] <- dev
    aggregate[,-1] <- aggregate[,-1] + dev[,-1]
  }
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())