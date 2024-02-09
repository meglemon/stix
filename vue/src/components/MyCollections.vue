<template>
    <div v-for="listName in lists" :key=lists>
       {{ listName }}
    </div>
</template>

<script>
import ListsService from '../services/ListsService';

export default {

    data(){
        return{
            listName: '',
            lists: []
        }
    },

    created(){
        ListsService
            .getListsByUserId(this.$store.state.user.id)
            .then((response) => {this.lists = response.data});
    }
    
}
</script>