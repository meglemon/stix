<template>
    <div>
        <label for="list-selector">Select a Stix Collection</label>
        <select name="list-selector" id="list-selector">
            <option v-for="listName in lists">{{ listName }}</option>
        </select>
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
        .then((response)=> {this.lists = response.data})
    }
}
</script>