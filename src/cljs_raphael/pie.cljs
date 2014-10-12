(ns cljs-raphael.pie)

(defn sector-mousein
  []
  (this-as this
   (.stop (.-sector this))
   (.scale (.-sector this) 1.1 1.1 (.-cx this) (.-cy this))
   (if (.-label this)
     (do
       (.stop (nth (.-items (.-label this)) 0))
       (.attr (nth (.-items (.-label this)) 0)
              (js-obj "r" 7.5))
       (.attr (nth (.-items (.-label this)) 1)
              (js-obj "font-weight" 800))))))

(defn sector-mouseout
  []
  (this-as this
   (.animate
    (.-sector this)
    (js-obj "transform" (str "s1 1 " (.-cx this) " " (.-cy this)))
    500 "bounce")
   (if (.-label this)
     (do
       (.animate (nth (.-items (.-label this)) 0) (js-obj "r" 5) 500 "bounce")
       (.attr (nth (.-items (.-label this)) 1) (js-obj "font-weight" 400))))))

(defn init []
  (let [r (js/Raphael "my-pie")
        pie (.piechart
             r 320 240 100
             (array 55 20 13 32 5 1 2 10)
             (js-obj "legend" (array "with-55" "with-20" "so on...")
                     "legendpos" "west"))]
    (.attr
     (.text r 320 100 "Clojurescript/Raphael Demo")
     (js-obj "font" "20px sans-serif"))
    (.hover pie sector-mousein sector-mouseout)))

(set! (.-onload js/window) init)
