<template>
    <form>
        <section>
            <label for="collection-name">What would you like to name your new collection?</label>
            <input type="text" name="collection-name" id="collection-name">
        </section>

        <section>
            <label for="list-items">Fill your list! Just hit <i>enter</i> after you type in your item!</label>
            <input type="text" name="list-items" id="list-items">
        </section>

        <button type="submit">Save New Collection</button>
        <button type="reset">Reset List</button>
        
        <section>
            List shows here while user puts items in
        </section>

    </form>
</template>

<script>
export default {
    
}
</script>