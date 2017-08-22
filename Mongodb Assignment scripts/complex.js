db.EMP.aggregate([
	//Last 3
    // Project your altered document form with a *new* field for "month"
    {"$project": {
        "ename" : 1,
        "tl" : {"$strLenCP" : "$ename"},

    }},
    {"$project": {
        "ename" : 1,
         "len" : { $subtract: [ "$tl" , 3 ] },
        "tl" : 1       
    }},
    {"$project": {
          "three":  {$substrCP: [ "$ename", "$len", { "$strLenCP": "$ename" } ]}
    }}
])