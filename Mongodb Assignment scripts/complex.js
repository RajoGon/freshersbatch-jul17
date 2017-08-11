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
])db.EMP.find().sort( {"sal" : 1}).limit(1)//min saldb.EMP.aggregate([	//min sal per dept    // Project your altered document form with a *new* field for "month"          {"$group": {       _id : "$deptno",        "minsal" : {$min : "$sal"}      }}])//Root Element to mapdb.EMP.aggregate([         {$group:{    _id: "$deptno" ,      "minsal": {$min:"$sal"},      "data": {"$push": "$$ROOT"}      }    },    {"$unwind":"$data"},      {"$project":{          "data" : 1,                           "minimum": {                 "$eq" : [ "$data.sal", "$minsal" ]             }        }},        {$match:{            "minimum" : true                        }},            {$project:{                 "ename" : "$data.ename"                }}])//Working in Ford's deptvar ford = db.EMP.findOne({"ename":"Ford"},{"dname":1})db.EMP.aggregate([{$match:{    "dname" : ford.dname    }}])//Ward's dept and earning more than martinvar ward = db.EMP.findOne({"ename":"Ward"},{"dname":1})var martin = db.EMP.findOne({"ename":"Martin"},{"sal":1})db.EMP.aggregate([{$match:{                "dname" : ward.dname,         "sal" : {$gt : martin.sal}          }}])