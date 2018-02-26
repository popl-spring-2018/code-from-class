(ns class-code.lab1.problem-1)

(defn legal-tweet
  [tweet-string]  
  (if (= (count tweet-string) 0)
    "Empty"
    (if ( > (count tweet-string) 140)
      "Too Long"
      (concat "Legal" (str  (count tweet-string)))))
  )


(defn legalTweet
  "checks if a string is a legal tweet"
  [tweet]
  (cond
    (= (count tweet) 0) "The tweet is empty"
    (> (count tweet) 140) "Tweet is tooooooooo loong"
    :else (str "this tweet is a good length " (count tweet))
    )
  )


(defn tweetLegal
  "I'm a little docstring"
  [tweet]
  (cond
    (= (count tweet) 0 ) "is empty"
    (> (count tweet) 140) "too long"
    :else "legal tweet")
  )


(defn legalTweet2
  [tweet]
  (let [len (count tweet)]
    (if (< len 1)
      "Tweet was empty."
      (if (< len 140)
        (str "legal message: of size " len)
        "tweet too long" ))))
