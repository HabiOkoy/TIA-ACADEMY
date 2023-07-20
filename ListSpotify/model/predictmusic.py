import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import linear_kernel

def recommend_songs(input_song_name, df, num_recommendations=10):
    # Assuming 'name' column contains the names of the songs

    # Preprocessing (if needed) - lowercase, remove special characters, etc.

    # TF-IDF vectorization
    tfidf_vectorizer = TfidfVectorizer()
    tfidf_matrix = tfidf_vectorizer.fit_transform(df['name'])

    # Calculate cosine similarity
    input_song_tfidf = tfidf_vectorizer.transform([input_song_name])
    cosine_similarities = linear_kernel(input_song_tfidf, tfidf_matrix).flatten()

    # Get indices of recommended songs
    similar_song_indices = cosine_similarities.argsort()[::-1][:num_recommendations]

    # Get the recommended songs from the dataset
    recommended_songs = df.iloc[similar_song_indices][['name', 'artist', 'release_date', 'length', 'popularity']]

    return recommended_songs

if __name__ == "__main__":
    # Load the dataset
    df3 = pd.read_csv('C:/semester 6/phyton/dataset/model.csv')

    # Get user input from command-line arguments
    user_input_song = input("Masukkan nama lagu: ")

    # Call the recommend_songs function to get recommendations
    recommendations = recommend_songs(user_input_song, df3)

    # Display the recommendations
    print(f"Rekomendasi lagu berdasarkan lagu '{user_input_song}':")
    print(recommendations)
