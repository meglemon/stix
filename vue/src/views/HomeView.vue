<template>
<body class="home">
<section class="elements-container">

<div class="header">
  <h2>Welcome back to STIX!</h2>
  <h3>Your solution for decision fatigue!!</h3>
</div>

<div class="row">
  <div class="left-column" style="background-color:#aaa;">View your current stix collections here
  <MyCollections/>
  </div>

  <div class="center-column" style="background-color:#bbb;">Use our randomizer here
  <RandomSelector/>
  </div>

  <div class="right-column" style="background-color:#ccc;">Create a new collection here
    <CollectionCreator/>
  </div>
</div>

<div class="footer">
  <p>Footer</p>
</div>

</section>
</body>
</template>

<script>
import CollectionCreator from '../components/CollectionCreator.vue';
import MyCollections from '../components/MyCollections.vue';
import RandomSelector from '../components/RandomSelector.vue';

export default {
  components: {
    CollectionCreator,
    MyCollections,
    RandomSelector
}
};
</script>

<style>
* {
  box-sizing: border-box;
}

/* Background Image */
.home {
  background-image: url("src/assets/lake.jpg"); 
  height: 100vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.elements-container {
  opacity: .9;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

/* Container for flexboxes */
.row {
  display: -webkit-flex;
  display: flex;
}

/* Create three columns that sits next to each other */
.left-column {
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}
.center-column {
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}
.right-column {
  -webkit-flex: 1;
  -ms-flex: 1;
  flex: 1;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 600px) {
  .row {
    -webkit-flex-direction: column;
    flex-direction: column;
  }
}

</style>